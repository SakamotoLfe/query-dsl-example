package com.querydslexample.exception;

import org.springframework.http.HttpStatus;

public class RestRequestException extends Exception {

    private final Integer statusCode;

    private final String message;

    public RestRequestException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public RestRequestException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode.value();
        this.message = message;
    }
}
