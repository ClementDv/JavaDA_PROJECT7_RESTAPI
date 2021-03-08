package com.nnk.springboot.exceptions;

public class EntityNotFoundException extends RuntimeException{
    private final Integer entityId;

    public EntityNotFoundException(Integer entityId) {
        super("Invalid entity id: " + entityId);
        this.entityId = entityId;
    }
}
