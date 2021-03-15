package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.dto.AbstractDto;
import com.nnk.springboot.domain.entity.AbstractEntity;
import com.nnk.springboot.domain.mapper.CoreMapper;
import com.nnk.springboot.exceptions.EntityNotFoundException;
import com.nnk.springboot.exceptions.InvalidModelException;
import com.nnk.springboot.services.CoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public abstract class CoreServiceImpl<Model extends AbstractDto, Entity extends AbstractEntity, ID> implements CoreService<Model, Entity, ID> {

    protected abstract <Repository extends JpaRepository<Entity, ID>> Repository getRepository();

    protected abstract <Mapper extends CoreMapper<Model, Entity>> Mapper getMapper();

    protected abstract String getName();

    @Override
    public List<Model> getList() {
        log.info(getName() + "Service: get list");
        return getRepository().findAll().stream().map(getMapper()::toModel).collect(Collectors.toList());
    }

    @Override
    public Model read(ID id) {
        try {
            Entity entity = getRepository().getOne(id);
            log.info(getName() + "Service: read entity with id " + id);
            return getMapper().toModel(entity);
        }
        catch (javax.persistence.EntityNotFoundException e)
        {
            log.error(getName() + "Service: error while reading entity with id " + id);
            throw new EntityNotFoundException((Integer) id);
        }
    }

    @Override
    public Model create(Model model) {
        if (model != null) {
            Entity entity = getMapper().fromModel(model);
            getRepository().save(entity);
            log.info(getName() + "Service: save new entity");
            return getMapper().toModel(entity);
        }
        log.error(getName() + "Service: error while saving new entity");
        throw new InvalidModelException("create", getName());
    }

    @Override
    public Model update(Model model) {
        if (model != null) {
                Entity entity = getRepository().getOne((ID) model.getId());
                getMapper().fromModel(entity, model);
                getRepository().save(entity);
                log.info(getName() + "Service: update entity with id" + entity.getId());
                return getMapper().toModel(entity);
        }
        log.error(getName() + "Service: error while updating " + getName() + "entity");
        throw new InvalidModelException("update", getName());
    }


    @Override
    public void deleteById(ID var1) {
        if (var1 != null) {
            log.info(getName() + "Service: delete new entity");
            getRepository().deleteById(var1);
        } else {
            log.error(getName() + "Service: error while deleting new entity");
            throw new InvalidModelException("delete", getName());
        }
    }
}
