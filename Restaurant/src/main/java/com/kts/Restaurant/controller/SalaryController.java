package com.kts.Restaurant.controller;

import com.kts.Restaurant.dto.SalaryDTO;
import com.kts.Restaurant.model.Role;
import com.kts.Restaurant.model.Salary;
import com.kts.Restaurant.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value="api/salary")
public class SalaryController {

    @Autowired
    SalaryService salaryService;




    @RequestMapping(value = {"/user/{id}", "/user/{id}/{from}", "/user/{id}/{from}/{to}" }, method = RequestMethod.GET)
    public ResponseEntity< Map<Double, List<SalaryDTO>> > totalProfitAndAllUserSalaries(
            @PathVariable Long id,
            @PathVariable Optional<String> from,
            @PathVariable Optional<String>  to
    ) throws ParseException {

        Map<Double, List<SalaryDTO>> retValue = new HashMap<>();
        retValue = salaryService.salaryReport(id,from,to);
        if (retValue.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(retValue, HttpStatus.OK);

    }



}

