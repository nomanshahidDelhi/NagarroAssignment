package com.example.Nagarro.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String message;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}

