package com.kts.Restaurant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.dto.OrderDTO;
import com.kts.Restaurant.dto.OrderedItemDTO;
import com.kts.Restaurant.dto.TableDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.service.OrderService;
import com.kts.Restaurant.service.OrderedItemService;

@RestController
@RequestMapping(value="api/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderedItemService orderedItemService;
	
	@RequestMapping(value="/{orderId}/drinks",method = RequestMethod.GET)
    public ResponseEntity<List<OrderedItemDTO>> placeNewOrderToTable(@PathVariable Long orderId) {
		
		List<OrderedItemDTO> orderedDrinks = orderedItemService.findDrinkOrderedItemByOrderId(orderId);
		
        return new ResponseEntity<>(orderedDrinks, HttpStatus.OK);
    }
	
	
}
