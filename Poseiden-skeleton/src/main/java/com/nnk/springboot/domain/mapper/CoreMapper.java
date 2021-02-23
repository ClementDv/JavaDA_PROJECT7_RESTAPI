package com.nnk.springboot.domain.mapper;

import org.mapstruct.MappingTarget;

public interface CoreMapper<Model, Entity> {

    Model toModel(Entity entity);

    Entity fromModel(Model model);

    void fromModel(@MappingTarget Entity targetEntity, Model model);
}
