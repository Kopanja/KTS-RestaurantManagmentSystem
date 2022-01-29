package com.kts.Restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class PinAlreadyExists extends RuntimeException{
    public PinAlreadyExists(){
        super("Pin already exists");
    }

}
