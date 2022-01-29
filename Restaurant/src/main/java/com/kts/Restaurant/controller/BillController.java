package com.kts.Restaurant.controller;

import com.kts.Restaurant.dto.*;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import com.kts.Restaurant.service.BartenderService;
import com.kts.Restaurant.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="api/bill")
public class BillController {
    @Autowired
    BillService billService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'WAITER', 'BARTENDER')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<BillCreateDTO> create(@RequestBody BillCreateRequestDTO billCreateDTO) {
        System.out.println(billCreateDTO);
        BillCreateDTO billkica = new BillCreateDTO(billCreateDTO.getCost(), billCreateDTO.getPrice(), new Date());
        System.out.println(billkica);
        BillCreateDTO bill;
        try {
            bill = billService.save(billkica);
            return new ResponseEntity<BillCreateDTO>(bill, HttpStatus.OK);

        }catch (UserWithUsernameAlreadyExistsException e){
            return new ResponseEntity<>(billkica, HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'BARTENDER')")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<BillWaiterStatisticsDTO>> getAll() {

        List<BillWaiterStatisticsDTO> bill;
        try {
            bill = billService.getAllBills();
            return new ResponseEntity<List<BillWaiterStatisticsDTO>>(bill, HttpStatus.OK);

        }catch (UserWithUsernameAlreadyExistsException e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

}
