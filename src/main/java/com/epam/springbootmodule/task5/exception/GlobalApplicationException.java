package com.epam.springbootmodule.task5.exception;

public class GlobalApplicationException extends RuntimeException {

    public GlobalApplicationException(String message) {
        super(message);
    }
}
