package com.loy.t1springsecurity.model.exception;

public class UserWithEmailAlreadyExistException extends RuntimeException {
    public UserWithEmailAlreadyExistException(String message) {
        super(message);
    }
}
