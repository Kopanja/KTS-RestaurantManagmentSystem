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
	
	public List<OrderedItemDTO> findAll(){
		List<OrderedItemDTO> orderedItems = new ArrayList<OrderedItemDTO>();
		for(OrderedItem item : orderedItemRepo.findAll()) {
			orderedItems.add(this.toDto(item));
		}
		return orderedItems;
	}
	
	public List<OrderedItemDTO>  findDrinkOrderedItemByOrderId(Long orderId){
		List<OrderedItemDTO> orderedItems = new ArrayList<OrderedItemDTO>();
		for(OrderedItem item : orderedItemRepo.findDrinkOrderedItemByOrderId(orderId)) {
			System.out.println("-------------------------------------------------");
			System.out.println(item);
			System.out.println("-------------------------------------------------");
			orderedItems.add(this.toDto(item));
		}
		return orderedItems;
	}
	
	
}
