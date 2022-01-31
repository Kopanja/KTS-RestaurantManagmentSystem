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
		ItemDTO dto = new ItemDTO(entity.getName(), entity.getPrice(), entity.getCost(), entity.getDescription());
		dto.setAlergens(entity.getAlergens());
		dto.setPrepTime(entity.getPrepTime());
		if(entity.getCategory() != null) {
			dto.setItemCategoryName(entity.getCategory().getCategoryName());
		}
		
		return dto;
	}

}
