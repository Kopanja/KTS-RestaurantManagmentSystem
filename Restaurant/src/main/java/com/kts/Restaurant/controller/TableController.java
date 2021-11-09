package com.kts.Restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.Restaurant.dto.RestaurantDTO;
import com.kts.Restaurant.dto.TableDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.Table;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.ItemRepository;
import com.kts.Restaurant.repository.UserRepository;
import com.kts.Restaurant.service.TableService;


@RestController
@RequestMapping(value="api/table")
public class TableController {

	@Autowired
	TableService tableService;
	
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value="/{id}/add-order",method = RequestMethod.POST)
    public ResponseEntity<Table> addOrderToTable(@PathVariable Long id) {
		Table table = tableService.findById(id);
		User user = userRepo.findById(5L).orElse(null);
		List<Item> orderItems = itemRepo.findAll();
		Order order = new Order();
		order.setUser(user);
		order.setItems(orderItems);
		table.setOrder(order);
		tableService.save(table);
		
        return new ResponseEntity<>(table, HttpStatus.OK);
    }
	
	@RequestMapping(value="/deleteAll",method = RequestMethod.DELETE)
    public ResponseEntity<Table> deleteAll() {
		
		tableService.deleteAll();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
