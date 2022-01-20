package com.kts.Restaurant.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ItemWithNameAlreadyExistsException extends RuntimeException{

    public ItemWithNameAlreadyExistsException() {
        super("Item with that name already exists");
    }
}
