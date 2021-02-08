package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.AbstractEntity;
import com.nnk.springboot.services.CoreService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CoreServiceImpl<T extends AbstractEntity, ID> implements CoreService<T, ID> {

    abstract <R extends JpaRepository<T, ID>> R getRepository();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAll(Sort var1) {
        return getRepository().findAll(var1);
    }

    @Override
    public Page<T> findAll(Pageable var1) {
        return getRepository().findAll(var1);
    }

    @Override
    public List<T> findAllById(Iterable<ID> var1) {
        return getRepository().findAllById(var1);
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> var1) {
        return getRepository().saveAll(var1);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }

    @Override
    public <S extends T> S saveAndFlush(S var1) {
        return getRepository().saveAndFlush(var1);
    }

    @Override
    public void deleteInBatch(Iterable<T> var1) {
        getRepository().deleteInBatch(var1);
    }

    @Override
    public void deleteAllInBatch() {
        getRepository().deleteAllInBatch();
    }

    @Override
    public T getOne(ID var1) {
        return getRepository().getOne(var1);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> var1) {
        return getRepository().findAll(var1);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> var1, Sort var2) {
        return getRepository().findAll(var1, var2);
    }

    @Override
    public <S extends T> S save(S var1) {
        return getRepository().save(var1);
    }

    @Override
    public Optional<T> findById(ID var1) {
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
        getRepository().deleteById(var1);
    }

    @Override
    public void delete(T var1) {
        getRepository().delete(var1);
    }

    @Override
    public void deleteAll(Iterable<? extends T> var1) {
        getRepository().deleteAll(var1);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }
}
