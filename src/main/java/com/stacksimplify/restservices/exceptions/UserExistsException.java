package com.stacksimplify.restservices.exceptions;

public class UserExistsException extends Exception {

    public UserExistsException(String message) {
        super(message);
    }

}