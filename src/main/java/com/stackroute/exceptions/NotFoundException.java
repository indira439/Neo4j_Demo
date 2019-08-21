package com.stackroute.exceptions;

/**
 * Custom Exception to throw if movie/actor is not found
 */
public class NotFoundException extends Exception {
    private String message;

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
