package com.nnk.springboot.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidModelException extends RuntimeException {
    private final String action;
    private final String serviceName;

    public InvalidModelException(String action, String serviceName) {
        super("Invalid Model for " + action + " " + serviceName);
        this.action = action;
        this.serviceName = serviceName;
    }
}
