package com.nnk.springboot.service;

import com.nnk.springboot.domain.dto.AbstractDto;
import com.nnk.springboot.domain.entity.AbstractEntity;
import com.nnk.springboot.domain.mapper.CoreMapper;
import com.nnk.springboot.exceptions.EntityNotFoundException;
import com.nnk.springboot.exceptions.InvalidModelException;
import com.nnk.springboot.services.CoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CoreServiceTest<
        Mapper extends CoreMapper<Model, Entity>,
        Repository extends JpaRepository<Entity, Integer>,
        Service extends CoreService<Model, Entity, Integer>,
        Model extends AbstractDto,
        Entity extends AbstractEntity> {

    protected abstract Service getService();

    protected abstract Mapper getMapper();

    protected abstract Repository getRepository();

    protected abstract Entity getTestEntity();

    protected abstract List<Entity> getListTestEntity();

    protected abstract Model getTestModel();

    protected abstract Entity getTestEntityToUpdate();


    @Test
    void getListTest() {
        List<Entity> entityList = getListTestEntity();
        Mockito.when(getRepository().findAll()).thenReturn(entityList);

        List<Model> answer = getService().getList();
        Assertions.assertEquals(entityList.stream().map(getMapper()::toModel).collect(Collectors.toList()),
                answer);
    }

    @Test
    void readTest() {
        Entity entity = getTestEntity();
        Mockito.when(getRepository().getOne(entity.getId())).thenReturn(entity);

        Model answer = getService().read(entity.getId());
        Assertions.assertEquals(getMapper().toModel(entity), answer);

        Mockito.when(getRepository().getOne(entity.getId() + 1)).thenThrow(javax.persistence.EntityNotFoundException.class);
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            getService().read(entity.getId() + 1);
        });
    }

    @Test
    void createTest() {
        Model model = getTestModel();
        Entity entity = getMapper().fromModel(model);
        Mockito.when(getRepository().save(entity)).thenReturn(entity);

        Model answer = getService().create(model);
        Assertions.assertEquals(model , answer);

        Assertions.assertThrows(InvalidModelException.class, () -> {
            getService().create(null);
        });
    }

    @Test
    void updateTest() {
        Model model = getTestModel();
        Entity entity = getMapper().fromModel(model);
        Entity entityToUpdate = getTestEntityToUpdate();
        Mockito.when(getRepository().getOne(model.getId())).thenReturn(entityToUpdate);
        Mockito.when(getRepository().save(entity)).thenReturn(entity);

        Model answer = getService().update(model);
        Assertions.assertEquals(model, answer);

        Assertions.assertThrows(InvalidModelException.class, () -> {
            getService().update(null);
        });
    }

    @Test
    void deleteByIdTest() {
        Model model = getTestModel();

        getService().deleteById(model.getId());
        Mockito.verify(getRepository(), Mockito.times(1)).deleteById(model.getId());

        Assertions.assertThrows(InvalidModelException.class, () -> {
            getService().deleteById(null);
        });
    }
}
