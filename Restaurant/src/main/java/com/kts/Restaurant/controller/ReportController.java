package com.kts.Restaurant.controller;

import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/report")
public class ReportController {

    @RequestMapping(value = "/biggestSalary/", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserWithBiggestSalary (){
        // napravicu
        return new ResponseEntity<>(null, HttpStatus.OK);
//        }
    }
}
