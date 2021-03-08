package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.dto.AbstractDto;
import com.nnk.springboot.domain.entity.AbstractEntity;
import com.nnk.springboot.domain.mapper.CoreMapper;
import com.nnk.springboot.exceptions.EntityNotFoundException;
import com.nnk.springboot.services.CoreService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CoreServiceImpl<Model extends AbstractDto, Entity extends AbstractEntity, ID> implements CoreService<Model, Entity, ID> {

    protected abstract <Repository extends JpaRepository<Entity, ID>> Repository getRepository();

    protected abstract <Mapper extends CoreMapper<Model, Entity>> Mapper getMapper();

    @Override
    public List<Model> getList() {
        return getRepository().findAll().stream().map(getMapper()::toModel).collect(Collectors.toList());
    }

    @Override
    public Model read(ID id){
        try {
            Entity entity = getRepository().getOne(id);
            return getMapper().toModel(entity);
        }
        catch (javax.persistence.EntityNotFoundException e)
        {
            throw new EntityNotFoundException((Integer) id);
        }
    }

    @Override
    public Model create(Model model) {
        Entity entity = getMapper().fromModel(model);
        getRepository().save(entity);
        return getMapper().toModel(entity);
    }

    @Override
    public Model update(Model model) {
        Entity entity = getRepository().getOne((ID) model.getId());
        getMapper().fromModel(entity, model);
        getRepository().save(entity);
        return getMapper().toModel(entity);
    }



    @Override
    public List<Entity> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<Entity> findAll(Sort var1) {
        return getRepository().findAll(var1);
    }

    @Override
    public Page<Entity> findAll(Pageable var1) {
        return getRepository().findAll(var1);
    }

    @Override
    public List<Entity> findAllById(Iterable<ID> var1) {
        return getRepository().findAllById(var1);
    }

    @Override
    public <S extends Entity> List<S> saveAll(Iterable<S> var1) {
        return getRepository().saveAll(var1);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }

    @Override
    public <S extends Entity> S saveAndFlush(S var1) {
        return getRepository().saveAndFlush(var1);
    }

    @Override
    public void deleteInBatch(Iterable<Entity> var1) {
        getRepository().deleteInBatch(var1);
    }

    @Override
    public void deleteAllInBatch() {
        getRepository().deleteAllInBatch();
    }

    @Override
    public Entity getOne(ID var1) {
        return getRepository().getOne(var1);
    }

    @Override
    public <S extends Entity> List<S> findAll(Example<S> var1) {
        return getRepository().findAll(var1);
    }

    @Override
    public <S extends Entity> List<S> findAll(Example<S> var1, Sort var2) {
        return getRepository().findAll(var1, var2);
    }

    @Override
    public <S extends Entity> S save(S var1) {
        return getRepository().save(var1);
    }

    @Override
    public Optional<Entity> findById(ID var1) {
        return getRepository().findById(var1);
    }

    @Override
    public boolean existsById(ID var1) {
        return getRepository().existsById(var1);
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public void deleteById(ID var1) {
        if (var1 != null) {
            getRepository().deleteById(var1);
        }
    }

    @Override
    public void delete(Entity var1) {
        getRepository().delete(var1);
    }

    @Override
    public void deleteAll(Iterable<? extends Entity> var1) {
        getRepository().deleteAll(var1);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }
}
