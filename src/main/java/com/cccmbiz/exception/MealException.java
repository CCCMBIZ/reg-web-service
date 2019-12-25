package com.cccmbiz.exception;

import org.springframework.http.HttpStatus;

public class MealException extends Exception {

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    private HttpStatus status;

    public MealException(String errorMessage) {
        super(errorMessage);
    }
}
