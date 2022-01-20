package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import com.kts.Restaurant.exceptions.ItemCategoryNameAlreadyExists;
import com.kts.Restaurant.exceptions.ItemCategoryNameDoesntExists;
import com.kts.Restaurant.exceptions.ItemCategoryTypeBadRequest;
import com.kts.Restaurant.model.*;
import com.kts.Restaurant.util.mapper.ItemCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.ItemCategoryDTO;
import com.kts.Restaurant.repository.ItemCategoryRepository;

@Service
public class ItemCategoryService {
	
	@Autowired
	ItemCategoryRepository itemCategoryRepo;


	public ItemCategoryDTO create(ItemCategoryDTO itemCatDTO) {

		if (itemCategoryRepo.findItemCategoryByCategoryName(itemCatDTO.getCategoryName()) != null) {
			throw new ItemCategoryNameAlreadyExists();
		}
		System.out.println(itemCatDTO.getType().equals("Food"));
		if(!itemCatDTO.getType().equals("Food") && !itemCatDTO.getType().equals("Drink")) {
			throw new ItemCategoryTypeBadRequest();
		}

		ItemCategory newItemCat = new ItemCategory();
		newItemCat.setCategoryName(itemCatDTO.getCategoryName());
		newItemCat.setType(itemCatDTO.getType());
		newItemCat.setIcon(itemCatDTO.getIcon());

		itemCategoryRepo.save(newItemCat);
		ItemCategoryMapper itemCatMapper = new ItemCategoryMapper();
		return itemCatMapper.toDto(newItemCat);
	}



	public ItemCategoryDTO update(String name, ItemCategoryDTO itemCatDTO) {
		if (itemCategoryRepo.findItemCategoryByCategoryName(name) == null) {
			throw new ItemCategoryNameDoesntExists();
		}

		ItemCategory itemCat = itemCategoryRepo.findItemCategoryByCategoryName(name);
		if(itemCat == null) {
			throw new ItemCategoryNameDoesntExists();
		}
		itemCat.setCategoryName(itemCatDTO.getCategoryName());
		itemCat.setIcon(itemCatDTO.getIcon());

		itemCategoryRepo.save(itemCat);
		ItemCategoryMapper itemCatMapper = new ItemCategoryMapper();
		return itemCatMapper.toDto(itemCat);
	}


	public ItemCategoryDTO findByName(String name) {
		ItemCategory itemCat = itemCategoryRepo.findItemCategoryByCategoryName(name);
		if(itemCat != null){
			ItemCategoryMapper itemCatMapper = new ItemCategoryMapper();
			return itemCatMapper.toDto(itemCat);
		}
		return null;


	}

	public List<ItemCategoryDTO> getFoodCategories(){
		List<ItemCategory> categories = itemCategoryRepo.getFoodCategories();
		List<ItemCategoryDTO> categoryDTOs = new ArrayList<ItemCategoryDTO>();
		ItemCategoryMapper catMapper = new ItemCategoryMapper();
		for(ItemCategory i : categories) {
			categoryDTOs.add(catMapper.toDto(i));
		}
		return categoryDTOs;
	}
	
	public List<ItemCategoryDTO> getDrinkCategories(){
		List<ItemCategory> categories = itemCategoryRepo.getDrinkCategories();
		List<ItemCategoryDTO> categoryDTOs = new ArrayList<ItemCategoryDTO>();
		ItemCategoryMapper catMapper = new ItemCategoryMapper();
		for(ItemCategory i : categories) {
			categoryDTOs.add(catMapper.toDto(i));
		}
		return categoryDTOs;
	}


}
