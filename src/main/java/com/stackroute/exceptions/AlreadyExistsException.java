package com.stackroute.exceptions;

/**
 * Custom Exception to throw if movie already exists
 */
public class AlreadyExistsException extends Exception {
    private String message;

    public AlreadyExistsException() {
    }

    public AlreadyExistsException(String message) {
        this.message = message;
    }
}
