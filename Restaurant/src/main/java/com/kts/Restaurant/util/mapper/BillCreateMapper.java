package com.kts.Restaurant.util.mapper;


import com.kts.Restaurant.dto.BillCreateDTO;
import com.kts.Restaurant.dto.BillWaiterStatisticsDTO;
import com.kts.Restaurant.model.Bill;
import com.kts.Restaurant.util.DTOMapperInterface;

import java.text.ParseException;

public class BillCreateMapper implements DTOMapperInterface<Bill, BillCreateDTO> {
    @Override
    public Bill toEntity(BillCreateDTO dto) {
        return new Bill(dto.getCost(), dto.getPrice(), dto.getDate());
    }

    @Override
    public BillCreateDTO toDto(Bill entity) {
        return new BillCreateDTO(entity.getCost(), entity.getPrice(), entity.getDate());
    }

}
