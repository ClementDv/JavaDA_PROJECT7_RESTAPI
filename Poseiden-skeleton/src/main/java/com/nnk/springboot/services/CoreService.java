package com.nnk.springboot.services;

import com.nnk.springboot.domain.dto.AbstractDto;
import com.nnk.springboot.domain.entity.AbstractEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CoreService<Model extends AbstractDto, Entity extends AbstractEntity, ID> {

    List<Model> getList();

    Model read(ID id);

    Model create(Model model);

    Model update(Model model);

    List<Entity> findAll();

    List<Entity> findAll(Sort var1);

    Page<Entity> findAll(Pageable var1);

    List<Entity> findAllById(Iterable<ID> var1);

    <S extends Entity> List<S> saveAll(Iterable<S> var1);

    void flush();

    <S extends Entity> S saveAndFlush(S var1);

    void deleteInBatch(Iterable<Entity> var1);

    void deleteAllInBatch();

    Entity getOne(ID var1);

    <S extends Entity> List<S> findAll(Example<S> var1);

    <S extends Entity> List<S> findAll(Example<S> var1, Sort var2);

    <S extends Entity> S save(S var1);

    Optional<Entity> findById(ID var1);

    boolean existsById(ID var1);

    long count();

    void deleteById(ID var1);

    void delete(Entity var1);

    void deleteAll(Iterable<? extends Entity> var1);

    void deleteAll();
}
