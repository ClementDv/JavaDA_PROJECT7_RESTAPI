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

    void deleteById(ID var1);

}
