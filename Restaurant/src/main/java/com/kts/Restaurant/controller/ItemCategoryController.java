package com.kts.Restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.Restaurant.dto.ItemCategoryDTO;
import com.kts.Restaurant.service.ItemCategoryService;

@RestController
@RequestMapping(value="api/item-category")
public class ItemCategoryController {
	
	@Autowired
	ItemCategoryService itemCategoryService;
	
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
