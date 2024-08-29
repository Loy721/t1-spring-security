package com.loy.t1springsecurity.model.exception;

public class UserWithUsernameAlreadyExistException extends RuntimeException {
    public UserWithUsernameAlreadyExistException(String message) {
        super(message);
    }
}
