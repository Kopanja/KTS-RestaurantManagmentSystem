package com.kts.Restaurant.controller;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.exceptions.ItemCategoryNameDoesntExists;
import com.kts.Restaurant.exceptions.ItemWithNameDoesntExists;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import com.itextpdf.text.DocumentException;
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

	
	   @GetMapping("/{itemName}/image")
	    public ResponseEntity<?> getProfileImage(@PathVariable String itemName) {        
	        try {
	            Path imagePath = Paths.get(".\\src\\main\\resources\\images\\items\\ClassicBurger.jpg");
	            if (imagePath != null) {
	                Resource resource = new ByteArrayResource(Files.readAllBytes(imagePath.normalize()));
	                
	                return ResponseEntity
	                        .ok()
	                        .contentLength(imagePath.toFile().length())
	                        .contentType(MediaType.IMAGE_JPEG)
	                        .body(resource); 
	                        
	               // return new ResponseEntity<ByteArrayResource>(resource,HttpStatus.OK);
	                
	            } else {
	                return ResponseEntity.status(HttpStatus.OK).build();
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	  
	   @GetMapping("/food-menu.pdf")
	    public ResponseEntity<?> getMenuPdf() {  
		   try {
			itemService.createFoodMenuPdf();
		} catch (FileNotFoundException | DocumentException e1) {
			e1.printStackTrace();
		}
	        try {
	            Path imagePath = Paths.get(".\\src\\main\\resources\\pdf\\food-menu.pdf");
	            if (imagePath != null) {
	                Resource resource = new ByteArrayResource(Files.readAllBytes(imagePath.normalize()));
	                System.out.println("A");
	                return ResponseEntity
	                        .ok()
	                        .contentLength(imagePath.toFile().length())
	                        .contentType(MediaType.APPLICATION_PDF)
	                        .body(resource); 
	                        
	               // return new ResponseEntity<ByteArrayResource>(resource,HttpStatus.OK);
	                
	            } else {
	                return ResponseEntity.status(HttpStatus.OK).build();
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	   
	   @GetMapping("/drink-menu.pdf")
	    public ResponseEntity<?> getDrinkMenuPdf() {  
		   try {
			itemService.createDrinkMenuPdf();
		} catch (FileNotFoundException | DocumentException e1) {
			e1.printStackTrace();
		}
	        try {
	            Path imagePath = Paths.get(".\\src\\main\\resources\\pdf\\drink-menu.pdf");
	            if (imagePath != null) {
	                Resource resource = new ByteArrayResource(Files.readAllBytes(imagePath.normalize()));
	                System.out.println("A");
	                return ResponseEntity
	                        .ok()
	                        .contentLength(imagePath.toFile().length())
	                        .contentType(MediaType.APPLICATION_PDF)
	                        .body(resource); 
	                        
	               // return new ResponseEntity<ByteArrayResource>(resource,HttpStatus.OK);
	                
	            } else {
	                return ResponseEntity.status(HttpStatus.OK).build();
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	
	
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
