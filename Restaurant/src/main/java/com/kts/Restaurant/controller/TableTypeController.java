package com.kts.Restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.Restaurant.dto.TableTypeDTO;
import com.kts.Restaurant.service.TableTypeService;

@RestController
@RequestMapping(value="api/table-type")
public class TableTypeController {

	@Autowired
	TableTypeService tableTypeService;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TableTypeDTO>> getAllTableTypes() {
		
		List<TableTypeDTO> tableTypes = tableTypeService.findAllDTOs();
		if(tableTypes == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<>(tableTypes, HttpStatus.OK);
    }
}
