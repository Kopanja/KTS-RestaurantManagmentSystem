package com.kts.Restaurant.service;

import com.kts.Restaurant.dto.SalaryDTO;
import com.kts.Restaurant.dto.UserSalaryDTO;
import com.kts.Restaurant.exceptions.UserNotFoundException;
import com.kts.Restaurant.model.Salary;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.SalaryRepository;
import com.kts.Restaurant.repository.UserRepository;
import com.kts.Restaurant.util.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    @Autowired
    UserRepository userRepository;


    public Salary saveSalary(Salary salary) {
        return salaryRepository.save(salary);
    }
   

    public Map<UserSalaryDTO, List<SalaryDTO>> salaryReport1(Long userId, Optional<String> from, Optional<String> to) throws ParseException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        UserSalaryDTO userSalaryDTO = new UserSalaryDTO(user.get().getFirstname(),user.get().getLastname(),user.get().getRole().getRole(),user.get().isActive());
        Double ukupnaZarada = 0.0;
        List<Salary> salaries = user.get().getSalaries();
        List<SalaryDTO> dtos = new ArrayList<>();
        SalaryMapper sMapper = new SalaryMapper();

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = from.isPresent() ? sf.parse(from.get()) : new Date(0);
        Date toDate = to.isPresent() ? sf.parse(to.get()) : new Date(System.currentTimeMillis());

        
        for (Salary s : salaries) {

            if (s.getSince().after(fromDate) && ( s.getTo() == null ||  s.getTo().before(toDate)) ) {
                ukupnaZarada += s.getSalaryAmount();
                dtos.add(sMapper.toDto(s));
            }

        }
        userSalaryDTO.setTotalSalary(ukupnaZarada);
        Map<UserSalaryDTO, List<SalaryDTO>> retVal = new HashMap<>();
        retVal.put(userSalaryDTO, dtos);


//         Map<Double, List<SalaryDTO>> retVal = new HashMap<>();
//         retVal.put(ukupnaZarada, dtos);
        
        return retVal;

    }


    public Map<Double, List<SalaryDTO>> salaryReport(Long userId, Optional<String> from, Optional<String> to) throws ParseException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        Double ukupnaZarada = 0.0;
        List<Salary> salaries = user.get().getSalaries();
        List<SalaryDTO> dtos = new ArrayList<>();
        SalaryMapper sMapper = new SalaryMapper();

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = from.isPresent() ? sf.parse(from.get()) : new Date(0);
        Date toDate = to.isPresent() ? sf.parse(to.get()) : new Date(System.currentTimeMillis());


        for (Salary s : salaries) {

            if (s.getSince().after(fromDate) && ( s.getTo() == null ||  s.getTo().before(toDate)) ) {
                ukupnaZarada += s.getSalaryAmount();
                dtos.add(sMapper.toDto(s));
            }

        }

        Map<Double, List<SalaryDTO>> retVal = new HashMap<>();
        retVal.put(ukupnaZarada, dtos);

        return retVal;

    }
 }
