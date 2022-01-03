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
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.Table;
import com.kts.Restaurant.service.OrderService;
import com.kts.Restaurant.service.OrderedItemService;
import com.kts.Restaurant.service.TableService;

@RestController
@RequestMapping(value="api/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	TableService tableService;
	
	@Autowired
	OrderedItemService orderedItemService;
	
	@RequestMapping(value="/{orderId}/drinks",method = RequestMethod.GET)
    public ResponseEntity<OrderDTO> findDrinksInOrder(@PathVariable Long orderId) {
		
		List<OrderedItemDTO> orderedDrinks = orderedItemService.findDrinkOrderedItemByOrderId(orderId);
		String tableName = tableService.findTableByOrderId(orderId).getName();
		OrderDTO dto = new OrderDTO();
		dto.setItems(orderedDrinks);
		dto.setTableName(tableName);
		dto.setOrderId(orderId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{orderId}/foods",method = RequestMethod.GET)
    public ResponseEntity<OrderDTO> findFoodsInOrder(@PathVariable Long orderId) {
		
		List<OrderedItemDTO> orderedDrinks = orderedItemService.findFoodOrderedItemByOrderId(orderId);
		String tableName = tableService.findTableByOrderId(orderId).getName();
		OrderDTO dto = new OrderDTO();
		dto.setItems(orderedDrinks);
		dto.setTableName(tableName);
		dto.setOrderId(orderId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{orderId}",method = RequestMethod.GET)
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long orderId) {
		Order order = orderService.findById(orderId);
		OrderDTO dto = orderService.toDto(order);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
	
	@RequestMapping(value="/ordered-item-made/{orderId}",method = RequestMethod.PUT)
    public ResponseEntity<String> drinkMade(@PathVariable Long orderId, @RequestBody OrderDTO order) {
		
		orderService.orderedItemMade(orderId, order);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
	
	
}
