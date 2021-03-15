package com.nnk.springboot.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityNotFoundException extends RuntimeException{
    private final Integer entityId;

    public EntityNotFoundException(Integer entityId) {
        super("Invalid entity id: " + entityId);
        this.entityId = entityId;
    }
}
