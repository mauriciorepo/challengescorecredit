package com.challenge.usercriticaldata.application.core.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String s){
        super(s);
    }
}
