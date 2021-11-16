package com.kts.Restaurant.util.mapper;


import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.util.DTOMapperInterface;

public class ItemMapper implements DTOMapperInterface<Item, ItemDTO> {

	
	
	@Override
	public Item toEntity(ItemDTO dto) {
		return null;
	}

	@Override
	public ItemDTO toDto(Item entity) {
		return new ItemDTO(entity.getName(), entity.getPrice(), entity.getCost());
	}

}
