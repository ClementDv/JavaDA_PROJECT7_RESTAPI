package com.nnk.springboot.exceptions;

public class EntityNotFoundException extends RuntimeException{
    private final Object entityId;

    public EntityNotFoundException(Object entityId) {
        super("Invalid entity id: " + entityId);
        this.entityId = entityId;
    }
}
