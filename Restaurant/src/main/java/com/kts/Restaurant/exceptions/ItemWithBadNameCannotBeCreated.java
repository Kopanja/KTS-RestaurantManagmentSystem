package com.kts.Restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ItemWithBadNameCannotBeCreated extends RuntimeException{

    public ItemWithBadNameCannotBeCreated() {
        super("Item can only be Drink or Food");
    }
}
