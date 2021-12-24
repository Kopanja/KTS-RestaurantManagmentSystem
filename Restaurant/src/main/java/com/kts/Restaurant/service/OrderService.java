package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.dto.OrderDTO;
import com.kts.Restaurant.dto.OrderedItemDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.OrderedItem;
import com.kts.Restaurant.repository.ОrderRepository;

@Service
public class OrderService {

	@Autowired
	ОrderRepository orderRepo;
	
	@Autowired
	OrderedItemService orderedItemService;
	
	@Autowired
	ItemService itemService;
	
	
	
	
	public OrderDTO toDto(Order order) {
		List<OrderedItem> items = order.getItems();
		List<OrderedItemDTO> itemDTOs = new ArrayList<OrderedItemDTO>();
		for(OrderedItem i : items) {
			itemDTOs.add(orderedItemService.toDto(i));
			
		}
		return new OrderDTO(itemDTOs);
		
	}
	
	public Order createOrderFromItemList(List<Item> items) {
		List<OrderedItem> orderedItems = orderedItemService.createOrderedItemListFromItems(items);
		
		return new Order(orderedItems);
	}

	public Order findById(Long id) {
		return orderRepo.findById(id).orElse(null);
	}

	public Order addItemsToExistingOrder(Order order, List<Item> items) {
		List<OrderedItem> orderedItems = orderedItemService.createOrderedItemListFromItems(items);
		for(OrderedItem i : orderedItems) {
			order.getItems().add(i);
		}
		return orderRepo.save(order);
	}
	
}
