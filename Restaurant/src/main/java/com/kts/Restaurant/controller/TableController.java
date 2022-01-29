package com.kts.Restaurant.controller;

import java.util.ArrayList;
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

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.dto.RestaurantDTO;
import com.kts.Restaurant.dto.TableDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.Table;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.ItemRepository;
import com.kts.Restaurant.repository.UserRepository;
import com.kts.Restaurant.service.TableService;
import com.kts.Restaurant.service.WaiterService;
import com.kts.Restaurant.util.mapper.ItemMapper;


@RestController
@RequestMapping(value="api/table")
public class TableController {

	@Autowired
	TableService tableService;
	
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	WaiterService waiterService;
	
	
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WAITER')")
	@RequestMapping(value="/{name}/place-order",method = RequestMethod.POST)
    public ResponseEntity<TableDTO> placeNewOrderToTable(@PathVariable String name, @RequestBody List<ItemDTO> items) {
		List<Item> newItems = new ArrayList<Item>();
		for(ItemDTO i : items) {
			newItems.add(itemRepo.findByName(i.getName()));
		}
		TableDTO table = waiterService.placeNewOrderForTable(name, newItems);
        return new ResponseEntity<>(table, HttpStatus.OK);
    }
	@PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WAITER')")
	@RequestMapping(value="/{name}/place-order",method = RequestMethod.PUT)
    public ResponseEntity<TableDTO> updateExistingOrder(@PathVariable String name, @RequestBody List<ItemDTO> items) {
		List<Item> newItems = new ArrayList<Item>();
		for(ItemDTO i : items) {
			newItems.add(itemRepo.findByName(i.getName()));
		}
		TableDTO table = waiterService.updateOrderForTable(name, newItems);
        return new ResponseEntity<>(table, HttpStatus.OK);
    }
	@PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WAITER')")
	@RequestMapping(value="/{name}/bill-order",method = RequestMethod.POST)
    public ResponseEntity<Boolean> billOrder(@PathVariable String name, @RequestBody List<ItemDTO> items) {
		System.out.println("Usao u Bill Order komandu");
//		waiterService.billOrder(name,items);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
	
	/*
	
	@RequestMapping(value="/deleteAll",method = RequestMethod.DELETE)
    public ResponseEntity<Table> deleteAll() {
		
		tableService.deleteAll();

        return new ResponseEntity<>(HttpStatus.OK);
    }
    */
}
