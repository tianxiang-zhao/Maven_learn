package com.idea.springboot04.exception;

public class UserNoExistException extends RuntimeException{
    public UserNoExistException(){
        super("no user");
    }
}
