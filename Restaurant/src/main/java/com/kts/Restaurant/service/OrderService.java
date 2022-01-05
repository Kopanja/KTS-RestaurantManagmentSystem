package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.dto.OrderDTO;
import com.kts.Restaurant.dto.OrderedItemDTO;
import com.kts.Restaurant.model.DrinkItem;
import com.kts.Restaurant.model.FoodItem;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.OrderedItem;
import com.kts.Restaurant.model.Table;
import com.kts.Restaurant.repository.ОrderRepository;

@Service
public class OrderService {

	@Autowired
	ОrderRepository orderRepo;
	
	@Autowired
	OrderedItemService orderedItemService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	TableService tableService;
	
	@Autowired
	WebSocketService webSocketService;
	
	
	public OrderDTO toDto(Order order) {
		List<OrderedItem> items = order.getItems();
		List<OrderedItemDTO> itemDTOs = new ArrayList<OrderedItemDTO>();
		for(OrderedItem i : items) {
			itemDTOs.add(orderedItemService.toDto(i));
			
		}
		Table table = tableService.findTableByOrderId(order.getId());
		return new OrderDTO(order.getId(),table.getName(), itemDTOs);
		
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
	
	public List<OrderDTO> getAllOrdersWithNotPreparedDrinkItems() {
		List<OrderDTO> ordersDTOs = new ArrayList<OrderDTO>();
		List<Order> orders = orderRepo.getAllOrdersWithDrinkItems();
		for(Order o : orders) {
			for(OrderedItem oi : o.getItems()) {
				if(!oi.isPrepared()) {
					ordersDTOs.add(this.toDto(o));
					break;
				}
			}
			
		}
		return ordersDTOs;
	}
	
	public boolean doesContainDrink(Order order) {
		for(OrderedItem item : order.getItems()) {
			if(item.getItem() instanceof DrinkItem) {
				return true;
			}
		}
		return false;
	}
	
	public OrderDTO getOrderByTableName(String tableName) {
		return this.toDto(orderRepo.findByTableName(tableName));
	}

	public List<OrderDTO> getAllOrdersWithNotPreparedFoodItems() {
		List<OrderDTO> ordersDTOs = new ArrayList<OrderDTO>();
		List<Order> orders = orderRepo.getAllOrdersWithFoodItems();
		for(Order o : orders) {
			for(OrderedItem oi : o.getItems()) {
				if(!oi.isPrepared()) {
					ordersDTOs.add(this.toDto(o));
					break;
				}
			}
			
		}
		return ordersDTOs;
	}
	
	public void orderedItemMade(Long orderedItemId, OrderDTO order) {
		orderedItemService.orderedItemChangePrepared(orderedItemId);
	
		String tableName = order.getTableName();
		OrderDTO dto = this.getOrderByTableName(tableName);
	
		webSocketService.sendOrderedItemChange(dto);
		
	}

	public boolean doesContainFood(Order order) {
		for(OrderedItem item : order.getItems()) {
			if(item.getItem() instanceof FoodItem) {
				return true;
			}
		}
		return false;
	}
	
	public void deleteOrderAndItsOrderedItems(Order order) {
		for(OrderedItem oItem : order.getItems()) {
			orderedItemService.delete(oItem);
		}
		this.delete(order);
	}
	
	public void delete(Order order) {
		orderRepo.delete(order);
	}
	
}
