package com.kts.Restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.Restaurant.dto.OrderDTO;
import com.kts.Restaurant.dto.OrderedItemDTO;
import com.kts.Restaurant.service.BartenderService;

@RestController
@RequestMapping(value="api/bartender")
public class BartenderController {
	
	@Autowired
	BartenderService bartenderService;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrderDTO>> getOrdersForBartender() {
		List<OrderDTO> orders = bartenderService.getOrdersForBartender();
		
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
	
	/*
	@RequestMapping(value="/drink-made/{drinkId}",method = RequestMethod.PUT)
    public ResponseEntity<String> drinkMade(@PathVariable Long drinkId, @RequestBody OrderDTO order) {
		
		bartenderService.drinkMade(drinkId, order);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    */

}
