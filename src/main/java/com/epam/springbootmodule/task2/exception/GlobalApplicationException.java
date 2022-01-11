package com.epam.springbootmodule.task2.exception;

public class GlobalApplicationException extends RuntimeException {

    public GlobalApplicationException(String message) {
        super(message);
    }
}
