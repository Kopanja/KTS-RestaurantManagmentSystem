package com.kts.Restaurant.controller;

import com.kts.Restaurant.dto.BillWaiterStatisticsDTO;
import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.dto.WaiterStatisticsDto;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import com.kts.Restaurant.service.BillService;
import com.kts.Restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="api/report")
public class ReportController {
    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/biggestSalary/", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserWithBiggestSalary (){
        // TODO: napravicu
        return new ResponseEntity<>(null, HttpStatus.OK);
//        }
    }

    @RequestMapping(value = "/waiterReport", method = RequestMethod.GET)
    public ResponseEntity<List<WaiterStatisticsDto>> waiterProfitStatistics() {
        List<UserDTO> waiters = userService.getAllByRole("WAITER");
        List<BillWaiterStatisticsDTO> bills = billService.getAllBills();

        System.out.println(waiters.get(0).toString());
        
        return null;
    }
}
