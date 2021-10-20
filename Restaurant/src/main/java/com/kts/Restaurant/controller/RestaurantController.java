package com.kts.Restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.Restaurant.dto.RestaurantDTO;
import com.kts.Restaurant.dto.TableDTO;
import com.kts.Restaurant.model.Table;
import com.kts.Restaurant.service.RestaurantService;
import com.kts.Restaurant.service.TableService;


@RestController
@RequestMapping(value="api/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	TableService tableService;

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
		
		List<RestaurantDTO> restaurants = restaurantService.findAll();
		if(restaurants == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<RestaurantDTO> getRestaurantFormById(@PathVariable Long id) {
        
		RestaurantDTO restaurant = restaurantService.findById(id);
        if(restaurant == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/table-layout",method = RequestMethod.GET)
    public ResponseEntity<List<TableDTO>> getTableLayout() {
        
		List<TableDTO> tables = tableService.getTableList();
        return new ResponseEntity<>(tables, HttpStatus.OK);
    }
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value= "/table-layout",method = RequestMethod.POST)
	public ResponseEntity<String> createNewLocation(@RequestBody List<TableDTO> tables){
        System.out.println("USAO");
        for(TableDTO dto : tables) {
        	System.out.println(dto);
        }
        try {
        	tableService.saveTableList(tables);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

}
