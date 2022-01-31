package com.kts.Restaurant.controller;

import com.itextpdf.text.DocumentException;
import com.kts.Restaurant.dto.*;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.RoleRepository;

import com.kts.Restaurant.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

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
    private BillService billService;

    @Autowired
    private UsernamePasswordCredentialsService UsernamePasswordCredentialsService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @RequestMapping(value = "/biggestSalary/", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserWithBiggestSalary (){
        // TODO: napravicu
        return new ResponseEntity<>(null, HttpStatus.OK);
//        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
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
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @RequestMapping(value = "/salary-payout", method = RequestMethod.GET)
    public ResponseEntity<?> getTotalSalaryPayoutByUser(){
        
			try {
				reportService.createTotalSalaryPayoutByUserReport();
			} catch (FileNotFoundException | ParseException | DocumentException e) {
				e.printStackTrace();
			}
		 
        return new ResponseEntity<>(null, HttpStatus.OK);

    }
    
    @GetMapping(value = "/pdf/{fileName}")
    public ResponseEntity<?> getReportPdf(@PathVariable String fileName) {  
        try {
            Path imagePath = Paths.get(".\\src\\main\\resources\\pdf\\report\\" + fileName);
            if (imagePath != null) {
                Resource resource = new ByteArrayResource(Files.readAllBytes(imagePath.normalize()));
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
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @RequestMapping(value = "/report-links", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getReportLinks(){
        
    		List<String> reportLinks = null;
    		reportLinks = reportService.getReportLinks();
        return new ResponseEntity<>(reportLinks, HttpStatus.OK);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @RequestMapping(value = {"/bill", "/bill/{from}", "/bill/{from}/{to}" }, method = RequestMethod.GET)
    public ResponseEntity< List<ItemReportDTO> > totalProfitAndAllUserSalaries(
            @PathVariable Optional<String> from,
            @PathVariable Optional<String>  to
    ) throws ParseException {
        List<ItemReportDTO> retValue = billService.billReport(from, to);


        return new ResponseEntity<>(retValue, HttpStatus.OK);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @RequestMapping(value = {"/waiter", "/waiter/{from}", "/waiter/{from}/{to}" }, method = RequestMethod.GET)
    public ResponseEntity< List<WaiterReportDTO> > waiterReport(
            @PathVariable Optional<String> from,
            @PathVariable Optional<String>  to
    ) throws ParseException {
        List<WaiterReportDTO> retValue = billService.billReportWaiter(from, to);


        return new ResponseEntity<>(retValue, HttpStatus.OK);

    }



}
