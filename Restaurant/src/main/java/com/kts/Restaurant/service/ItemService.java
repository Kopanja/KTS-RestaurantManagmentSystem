package com.kts.Restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.repository.ItemRepository;
import com.kts.Restaurant.util.mapper.ItemMapper;

@Service
public class ItemService {
	
	ItemMapper mapper = new ItemMapper();
	
	@Autowired
	ItemRepository itemRepo;
	
	
	public ItemDTO toDto(Item item) {
		return mapper.toDto(item);
	}

}
