package com.kts.Restaurant.util.mapper;


import com.kts.Restaurant.dto.BillWaiterStatisticsDTO;
import com.kts.Restaurant.model.Bill;
import com.kts.Restaurant.util.DTOMapperInterface;

public class BillMapper implements DTOMapperInterface<Bill, BillWaiterStatisticsDTO> {
    @Override
    public Bill toEntity(BillWaiterStatisticsDTO dto) {
        return null;
    }

    @Override
    public BillWaiterStatisticsDTO toDto(Bill entity) {
        return new BillWaiterStatisticsDTO(entity.getPrice(), entity.getCost(), entity.getWaiter());
    }

}
