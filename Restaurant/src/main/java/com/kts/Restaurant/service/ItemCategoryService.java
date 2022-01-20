package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.ItemCategoryDTO;
import com.kts.Restaurant.model.ItemCategory;
import com.kts.Restaurant.repository.ItemCategoryRepository;

@Service
public class ItemCategoryService {
	
	@Autowired
	ItemCategoryRepository itemCategoryRepo;
	
	
	private ItemCategoryDTO toDto(ItemCategory category) {
		if(category.getId() != null) {
			return new ItemCategoryDTO(category.getId(),category.getType(), category.getCategoryName(), category.getIcon());
		}else {
			return new ItemCategoryDTO(category.getType(), category.getCategoryName(), category.getIcon());
		}
	}
	
	public List<ItemCategoryDTO> getFoodCategories(){
		List<ItemCategory> categories = itemCategoryRepo.getFoodCategories();
		List<ItemCategoryDTO> categoryDTOs = new ArrayList<ItemCategoryDTO>();
		
		for(ItemCategory i : categories) {
			categoryDTOs.add(this.toDto(i));
		}
		return categoryDTOs;
	}
	
	public List<ItemCategoryDTO> getDrinkCategories(){
		List<ItemCategory> categories = itemCategoryRepo.getDrinkCategories();
		List<ItemCategoryDTO> categoryDTOs = new ArrayList<ItemCategoryDTO>();
		
		for(ItemCategory i : categories) {
			categoryDTOs.add(this.toDto(i));
		}
		return categoryDTOs;
	}

}
