package com.kts.Restaurant.controller;

import java.util.List;

import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.exceptions.*;
import com.kts.Restaurant.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.kts.Restaurant.dto.ItemCategoryDTO;
import com.kts.Restaurant.service.ItemCategoryService;

@RestController
@RequestMapping(value="api/item-category")
public class ItemCategoryController {
	
	@Autowired
	ItemCategoryService itemCategoryService;

	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ItemCategoryDTO> create(@RequestBody ItemCategoryDTO itemCategoryDTO) {

        ItemCategoryDTO itemCat;
        try {
            itemCat = itemCategoryService.create(itemCategoryDTO);
            return new ResponseEntity<>(itemCat, HttpStatus.OK);

        }catch (ItemCategoryTypeBadRequest | ItemCategoryNameAlreadyExists e){
            return new ResponseEntity<>(itemCategoryDTO, HttpStatus.BAD_REQUEST);
        }
    }

	@PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value = "/update/{name}", method = RequestMethod.PUT)
    public ResponseEntity<ItemCategoryDTO> update(@PathVariable String name, @RequestBody ItemCategoryDTO itemCategoryDTO) {

        ItemCategoryDTO itemCat;
        try {
            itemCat = itemCategoryService.update(name, itemCategoryDTO);
            return new ResponseEntity<>(itemCat, HttpStatus.OK);
        }catch (ItemCategoryNameDoesntExists e){
            return new ResponseEntity<>(itemCategoryDTO, HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<ItemCategoryDTO> getALl(@PathVariable String name){
        ItemCategoryDTO itemCat = itemCategoryService.findByName(name);
        if(itemCat == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(itemCat, HttpStatus.OK);
    }


  
	@RequestMapping(value= "/food-categories",method = RequestMethod.GET)
    public ResponseEntity<List<ItemCategoryDTO>> getFoodCategories() {
        
		List<ItemCategoryDTO> foodCategories = itemCategoryService.getFoodCategories();
        return new ResponseEntity<>(foodCategories, HttpStatus.OK);
    }
	
	
	@RequestMapping(value= "/drink-categories",method = RequestMethod.GET)
    public ResponseEntity<List<ItemCategoryDTO>> getDrinkCategories() {
        
		List<ItemCategoryDTO> drinkCategories = itemCategoryService.getDrinkCategories();
        return new ResponseEntity<>(drinkCategories, HttpStatus.OK);
    }

}
