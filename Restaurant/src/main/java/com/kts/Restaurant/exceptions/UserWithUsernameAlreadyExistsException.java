package com.kts.Restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class UserWithUsernameAlreadyExistsException extends  RuntimeException{

    public UserWithUsernameAlreadyExistsException() {
        super("User with that username already exists");
    }
}
