package com.kts.Restaurant.util.mapper;

import com.kts.Restaurant.dto.ItemCategoryDTO;
import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.ItemCategory;
import com.kts.Restaurant.util.DTOMapperInterface;

public class ItemCategoryMapper implements DTOMapperInterface<ItemCategory, ItemCategoryDTO> {
    @Override
    public ItemCategory toEntity(ItemCategoryDTO itemCategoryDTO) {
        return null;
    }

    @Override
    public ItemCategoryDTO toDto(ItemCategory itemCategory) {
        return new ItemCategoryDTO(itemCategory.getType(), itemCategory.getCategoryName(), itemCategory.getIcon());

    }
}

