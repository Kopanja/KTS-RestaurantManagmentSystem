package com.kts.Restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ItemWithNameDoesntExists extends RuntimeException{
    public ItemWithNameDoesntExists(){
        super("Item with that name doesn't exists");
    }
}
