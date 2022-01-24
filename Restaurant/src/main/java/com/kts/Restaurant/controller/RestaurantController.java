package com.kts.Restaurant.controller;

import java.util.ArrayList;
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

import com.kts.Restaurant.dto.FloorDTO;
import com.kts.Restaurant.dto.TableDTO;
import com.kts.Restaurant.model.Floor;
import com.kts.Restaurant.model.FoodItem;
import com.kts.Restaurant.model.Table;
import com.kts.Restaurant.service.FloorService;
import com.kts.Restaurant.service.TableService;


@RestController
@RequestMapping(value="api/restaurant")
public class RestaurantController {
	

	@Autowired
	TableService tableService;
	
	@Autowired
	FloorService floorService;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/reset-db",method = RequestMethod.GET)
    public ResponseEntity<String> resetDB() {
		
        String s = "";
        try {
        	tableService.resetDB();
        	s = "success";
        }catch(Exception e) {
        	  s = "fail";
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/{name}/table-layout",method = RequestMethod.GET)
    public ResponseEntity<List<TableDTO>> getTableLayout(@PathVariable String name) {
        
		List<TableDTO> tables = tableService.getTableListByFloorName(name);
        return new ResponseEntity<>(tables, HttpStatus.OK);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/floors",method = RequestMethod.GET)
    public ResponseEntity<List<FloorDTO>> getAllFloors() {
        
		List<FloorDTO> floors = floorService.getAll();
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value= "/table-layout",method = RequestMethod.POST)
	public ResponseEntity<String> createNewTableLayout(@RequestBody List<TableDTO> tables){
		
        tableService.deleteAll();
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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value= "/new-floor/{name}",method = RequestMethod.POST)
	public ResponseEntity<String> createNewFloor(@PathVariable String name, @RequestBody List<TableDTO> tables){
		Floor floor = new Floor();
        floor.setName(name);
        List<Table> tableList = new ArrayList<Table>();
        for(TableDTO dto : tables) {
        	tableList.add(tableService.toEntity(dto));
        }
        floor.setTables(tableList);
        floorService.save(floor);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/deleteAll",method = RequestMethod.DELETE)
    public ResponseEntity<Table> deleteAll() {
		
		tableService.deleteAll();
		System.out.println("DELETED");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
