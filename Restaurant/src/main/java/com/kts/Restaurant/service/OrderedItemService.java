package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.OrderedItemDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.OrderedItem;
import com.kts.Restaurant.repository.OrderedItemRepository;

@Service
public class OrderedItemService {

	@Autowired
	OrderedItemRepository orderedItemRepo;
	
	@Autowired
	ItemService itemService;
	
	public OrderedItemDTO toDto(OrderedItem item) {
		return new OrderedItemDTO(itemService.toDto(item.getItem()), item.isPrepared());
	}
	
	public OrderedItem createOrderedItemFromItem(Item item){
		return new OrderedItem(item, false);
	}
	
	
	public List<OrderedItem> createOrderedItemListFromItems(List<Item> items){
		List<OrderedItem> orderedItems = new ArrayList<OrderedItem>();
		
		for(Item item : items) {
			orderedItems.add(this.createOrderedItemFromItem(item));
		}
		return orderedItems;
	}
	
	public List<OrderedItem> findDrinksFromOrder(Long orderId){
		return orderedItemRepo.findDrinksFromOrder(orderId);
	}
	
	public List<OrderedItem> findFoodsFromOrder(Long orderId){
		return orderedItemRepo.findFoodsFromOrder(orderId);
	}
}
