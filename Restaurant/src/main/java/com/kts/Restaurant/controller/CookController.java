package com.kts.Restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.Restaurant.dto.OrderDTO;
import com.kts.Restaurant.service.CookService;


@RestController
@RequestMapping(value="api/cook")
public class CookController {
	
	@Autowired
	CookService cookService;
	@PreAuthorize("hasAnyAuthority('ADMIN', 'COOK', 'BARTENDER')")
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrderDTO>> getOrdersForCook() {
		List<OrderDTO> orders = cookService.getOrdersForCook();
		
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
	/*
	@RequestMapping(value="/food-made/{foodId}",method = RequestMethod.PUT)
    public ResponseEntity<String> drinkMade(@PathVariable Long foodId, @RequestBody OrderDTO order) {
		
		cookService.foodMade(foodId, order);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    */

}
