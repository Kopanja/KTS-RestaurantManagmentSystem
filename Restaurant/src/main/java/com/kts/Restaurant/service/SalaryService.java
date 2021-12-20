package com.kts.Restaurant.service;

import com.kts.Restaurant.model.Salary;
import com.kts.Restaurant.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    public Salary saveSalary(Salary salary) {
        return salaryRepository.save(salary);
    }
}
