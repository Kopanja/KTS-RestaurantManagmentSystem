package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.dto.OrderDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.repository.ОrderRepository;

@Service
public class OrderService {

	@Autowired
	ОrderRepository orderRepo;
	
	@Autowired
	ItemService itemService;
	
	
	public OrderDTO toDto(Order order) {
		List<Item> items = order.getItems();
		List<ItemDTO> itemDTOs = new ArrayList<ItemDTO>();
		for(Item i : items) {
			itemDTOs.add(itemService.toDto(i));
		}
		return new OrderDTO(itemDTOs);
		
	}
	
}
