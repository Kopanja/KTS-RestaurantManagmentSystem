package com.kts.Restaurant.controller;

import com.kts.Restaurant.dto.BillWaiterStatisticsDTO;
import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.dto.WaiterStatisticsDto;
import com.kts.Restaurant.dto.WaiterStatistictsResponseDTO;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.service.BillService;
import com.kts.Restaurant.service.UserService;
import com.kts.Restaurant.service.UsernamePasswordCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="api/report")
public class ReportController {
    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

    @Autowired
    private UsernamePasswordCredentialsService UsernamePasswordCredentialsService;

    @RequestMapping(value = "/biggestSalary/", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserWithBiggestSalary (){
        // TODO: napravicu
        return new ResponseEntity<>(null, HttpStatus.OK);
//        }
    }

    @RequestMapping(value = "/waiterReport", method = RequestMethod.GET)
    public ResponseEntity<List<WaiterStatistictsResponseDTO>> waiterProfitStatistics() {
        Map<User, Double> waiterStatistics = userService.getWaiterStatistics();

        // map result to DTO
        List<WaiterStatistictsResponseDTO> result = new ArrayList<>();
        for (User user: waiterStatistics.keySet()) {
            WaiterStatistictsResponseDTO dto = new WaiterStatistictsResponseDTO();
            dto.setProfit(waiterStatistics.get(user));
            dto.setName(user.getFirstname() + ' ' + user.getLastname());
            result.add(dto);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
