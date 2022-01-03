package com.kts.Restaurant.util.mapper;

import com.kts.Restaurant.dto.OrderedItemDTO;
import com.kts.Restaurant.model.OrderedItem;
import com.kts.Restaurant.util.DTOMapperInterface;

public class OrderedItemMapper implements DTOMapperInterface<OrderedItem, OrderedItemDTO> {

	ItemMapper itemMapper = new ItemMapper();
	
	@Override
	public OrderedItem toEntity(OrderedItemDTO dto) {
		return null;
	}

	@Override
	public OrderedItemDTO toDto(OrderedItem entity) {
		return new OrderedItemDTO(entity.getId(), itemMapper.toDto(entity.getItem()), entity.isPrepared());
	}

}
