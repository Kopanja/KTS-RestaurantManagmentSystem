package com.kts.Restaurant.controller;

import com.itextpdf.text.DocumentException;
import com.kts.Restaurant.dto.*;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.RoleRepository;
import com.kts.Restaurant.service.ItemService;
import com.kts.Restaurant.service.ReportService;
import com.kts.Restaurant.service.UserService;
import com.kts.Restaurant.service.UsernamePasswordCredentialsService;
import com.kts.Restaurant.service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value="api/report")
public class ReportController {


    @Autowired
    WaiterService waiterService;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    ReportService reportService;

    @Autowired
    private UsernamePasswordCredentialsService UsernamePasswordCredentialsService;

    @RequestMapping(value = "/biggestSalary/", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserWithBiggestSalary (){
        // TODO: napravicu
        return new ResponseEntity<>(null, HttpStatus.OK);
//        }
    }

    @RequestMapping(path = {"/waiterReport", "/waiterReport/{from}", "/waiterReport/{from}/{to}"})
    public ResponseEntity<List<WaiterStatistictsResponseDTO>> waiterProfitStatistics(
            @PathVariable Optional<String>  from,
            @PathVariable Optional<String>  to
    ) throws ParseException {

        Map<User, Double> waiterStatistics;
        if (!from.isPresent()) {
            waiterStatistics = waiterService.getWaiterStatistics(null, null);
        }
        else{
            if (!to.isPresent()) {
                waiterStatistics = waiterService.getWaiterStatistics(from.get(), null);
            }else{
                waiterStatistics = waiterService.getWaiterStatistics(from.get(), to.get());
            }
        }
        // TODO: prebaci ispod logiku i service i neka on vraca vec dto
        // map result to DTO
        List<WaiterStatistictsResponseDTO> result = new ArrayList<>();
        for (User user: waiterStatistics.keySet()) {
            WaiterStatistictsResponseDTO dto = new WaiterStatistictsResponseDTO();
            dto.setProfit(waiterStatistics.get(user));
            dto.setName(user.getFirstname());
            dto.setLastname(user.getLastname());
            if (dto.getRole() != null) {
                dto.setRole(user.getRole().getRole());
            } else {
                dto.setRole(roleRepository.findByRole("MANAGER").getRole());
            }

            result.add(dto);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/salary-payout", method = RequestMethod.GET)
    public ResponseEntity<?> getTotalSalaryPayoutByUser(){
        
			try {
				reportService.createTotalSalaryPayoutByUserReport();
			} catch (FileNotFoundException | ParseException | DocumentException e) {
				e.printStackTrace();
			}
		 
        return new ResponseEntity<>(null, HttpStatus.OK);
//        }
    }



}
