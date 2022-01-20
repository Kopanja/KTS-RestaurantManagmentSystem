package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import com.kts.Restaurant.exceptions.*;
import com.kts.Restaurant.model.*;
import com.kts.Restaurant.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.repository.ItemRepository;
import com.kts.Restaurant.util.mapper.ItemMapper;

@Service
public class ItemService {
	

	@Autowired
	ItemRepository itemRepo;

	@Autowired
	ItemCategoryRepository itemCatRepository;

	public ItemDTO create(ItemDTO itemDTO) {
		if (itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()) == null) {
			throw new ItemCategoryNameDoesntExists();
		}
		if (itemRepo.findByName(itemDTO.getName()) != null){
			throw new ItemWithNameAlreadyExistsException();
		}
		Item newItem = null;
		if (itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()).getType().equals("Food")){
			newItem = new FoodItem();
		}else if(itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()).getType().equals("Dring")){
			newItem = new DrinkItem();
		}

		newItem.setName(itemDTO.getName());
		newItem.setActive(true);
		newItem.setCategory(itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()));
		newItem.setCost(itemDTO.getCost());
		newItem.setPrice(itemDTO.getPrice());
		newItem.setDescription(itemDTO.getDescription());
		itemRepo.save(newItem);
		ItemMapper itemMapper = new ItemMapper();
		return itemMapper.toDto(newItem);
	}


	public ItemDTO update(String oldName, ItemDTO itemDTO) {
		if (itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()) == null) {
			throw new ItemCategoryNameDoesntExists();
		}
		if (itemRepo.findByName(oldName) == null){
			throw new ItemWithNameDoesntExists();
		}
		// obrisi stari item postavljajuci ga na false
		Item itemToDelete = itemRepo.findByName(oldName);
		itemToDelete.setActive(false);
		itemRepo.save(itemToDelete);

		// pravi nov
		Item newUpdatedItem = null;
		if (itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()).getType().equals("Food")){
			newUpdatedItem = new FoodItem();
		}else if(itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()).getType().equals("Dring")){
			newUpdatedItem = new DrinkItem();
		}

		newUpdatedItem.setActive(true);
		newUpdatedItem.setName(itemDTO.getName());
		newUpdatedItem.setPrice(itemDTO.getPrice());
		newUpdatedItem.setCost(itemDTO.getCost());
		newUpdatedItem.setCategory(itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()));
		newUpdatedItem.setDescription(itemDTO.getDescription());
		itemRepo.save(newUpdatedItem);
		ItemMapper itemMapper = new ItemMapper();
		return itemMapper.toDto(newUpdatedItem);

	}




	public ItemDTO toDto(Item item) {
		ItemMapper mapper = new ItemMapper();
		return mapper.toDto(item);
	}
	
	

	public Item toEntity(ItemDTO dto) {
		return itemRepo.findByName(dto.getName());
	}
	public List<ItemDTO> getAll(){
		List<ItemDTO> dtos = new ArrayList<ItemDTO>();
		ItemMapper mapper = new ItemMapper();
		for(Item i : itemRepo.findAll()) {
			dtos.add(mapper.toDto(i));
		}
		return dtos;
	}
	
	public List<ItemDTO> getItemsByCategoryName(String categoryName){
		List<ItemDTO> dtos = new ArrayList<ItemDTO>();
		ItemMapper mapper = new ItemMapper();
		for(Item i : itemRepo.findByCategoryName(categoryName)) {
			dtos.add(mapper.toDto(i));
		}
		return dtos;
	}


}
