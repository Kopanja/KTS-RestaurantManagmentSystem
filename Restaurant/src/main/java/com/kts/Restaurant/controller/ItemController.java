package com.kts.Restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.Restaurant.model.FoodItem;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.ItemRepository;
import com.kts.Restaurant.repository.UserRepository;
import com.kts.Restaurant.repository.ОrderRepository;

@RestController
@RequestMapping(value="api/item")
public class ItemController {

	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	ОrderRepository orderRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value= "/add-item",method = RequestMethod.POST)
	public ResponseEntity<String> createNewLocation(@RequestBody FoodItem item){
		User user = userRepo.findById(5L).orElse(null);
		List<Item> orderItems = itemRepo.findAll();
		Order order = new Order();
		order.setUser(user);
		order.setItems(orderItems);
		orderRepo.save(order);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
