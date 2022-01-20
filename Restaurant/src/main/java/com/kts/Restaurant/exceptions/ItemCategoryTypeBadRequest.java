package com.kts.Restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ItemCategoryTypeBadRequest extends RuntimeException{

    public ItemCategoryTypeBadRequest() {
        super("Category type can only be Drink or Food");
    }

}
