package com.chat.util.Exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message){
        super(message);
    }

}
