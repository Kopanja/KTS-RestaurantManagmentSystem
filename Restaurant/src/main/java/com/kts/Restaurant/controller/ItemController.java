package com.kts.Restaurant.controller;

import java.util.List;

import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.exceptions.ItemCategoryNameDoesntExists;
import com.kts.Restaurant.exceptions.ItemWithNameDoesntExists;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.dto.OrderedItemDTO;
import com.kts.Restaurant.dto.TableDTO;
import com.kts.Restaurant.model.FoodItem;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.ItemRepository;
import com.kts.Restaurant.repository.UserRepository;
import com.kts.Restaurant.repository.ОrderRepository;
import com.kts.Restaurant.service.ItemService;
import com.kts.Restaurant.service.OrderedItemService;

@RestController
@RequestMapping(value="api/item")
public class ItemController {

	@Autowired
	ItemRepository itemRepo;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ОrderRepository orderRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OrderedItemService orderedItemService;

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO itemDTO) {

		ItemDTO item;
		try {
			item = itemService.create(itemDTO);
			return new ResponseEntity<>(item, HttpStatus.OK);

		}catch (ItemCategoryNameDoesntExists | ItemWithNameDoesntExists e){
			return new ResponseEntity<>(itemDTO, HttpStatus.BAD_REQUEST);
		}
	}


	@RequestMapping(value = "/update/{name}",method = RequestMethod.PUT)
	public ResponseEntity<ItemDTO> update(@PathVariable String name, @RequestBody ItemDTO itemDTO) {

		ItemDTO item;
		try {
			item = itemService.update(name, itemDTO);
			return new ResponseEntity<>(item, HttpStatus.OK);

		}catch (ItemCategoryNameDoesntExists e){
			return new ResponseEntity<>(itemDTO, HttpStatus.BAD_REQUEST);
		}
	}


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ItemDTO>> getItemList() {
        
		List<ItemDTO> items = itemService.getAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/{orderId}/ordered-items",method = RequestMethod.GET)
    public ResponseEntity<List<OrderedItemDTO>> getOrderedItemst(@PathVariable Long orderId) {
        
		List<OrderedItemDTO> orderedItems = orderedItemService.findAll();
        return new ResponseEntity<>(orderedItems, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/{categoryName}",method = RequestMethod.GET)
    public ResponseEntity<List<ItemDTO>> getItemsByCategoryName(@PathVariable String categoryName) {
        
		List<ItemDTO> items = itemService.getItemsByCategoryName(categoryName);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
