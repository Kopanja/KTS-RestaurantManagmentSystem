package com.kts.Restaurant.util.mapper;

import com.kts.Restaurant.dto.OrderDTO;
import com.kts.Restaurant.dto.SalaryDTO;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.Salary;
import com.kts.Restaurant.util.DTOMapperInterface;

public class SalaryMapper  implements DTOMapperInterface<Salary, SalaryDTO> {
    @Override
    public Salary toEntity(SalaryDTO salaryDTO) {
        return null;
    }

    @Override
    public SalaryDTO toDto(Salary salary) {
        return new SalaryDTO(salary.getSalaryAmount(), salary.getSince(), salary.getTo(), salary.getActive());
    }
}
