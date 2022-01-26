package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.dto.TableDTO;
import com.kts.Restaurant.model.Bill;
import com.kts.Restaurant.model.DrinkItem;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.OrderedItem;
import com.kts.Restaurant.model.Table;

@Service
public class WaiterService {

	@Autowired
	TableService tableService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	BillService billService;
	
	@Autowired
	WebSocketService webSocketService;
	
	
	
	public TableDTO placeNewOrderForTable(String tableName, List<Item> items) {
		Table table = tableService.findByName(tableName);
		Order order = orderService.createOrderFromItemList(items);
		table.setOrder(order);
		table = tableService.save(table);
		
		if(orderService.doesContainDrink(order)) {
			webSocketService.sendDrinkOrder(order.getId());
		}
		if(orderService.doesContainFood(order)) {
			webSocketService.sendFoodOrder(order.getId());
		}
		
		return tableService.toDto(table);
	}
	
	public TableDTO updateOrderForTable(String tableName, List<Item> newItems) {
		Table table = tableService.findByName(tableName);
		Order order = orderService.findById(table.getOrder().getId());
		order = orderService.addItemsToExistingOrder(order, newItems);
		//List<DrinkItem> newDrinks = new ArrayList<DrinkItem>();
		//for(Item i : newItems) {
		//	if(i instanceof DrinkItem) {
		//		newDrinks.add((DrinkItem) i);
		//	}
		//}
		table.setOrder(order);
		if(orderService.doesContainDrink(order)) {
			webSocketService.sendDrinkOrder(order.getId());
		}
		if(orderService.doesContainFood(order)) {
			webSocketService.sendFoodOrder(order.getId());
		}
		return tableService.toDto(table);
//	}
//
//	public void billOrder(String tableName, List<ItemDTO> items) {
//		Table table = tableService.findByName(tableName);
//		Order order = orderService.findById(table.getOrder().getId());
//		Bill bill = billService.createBillFromOrder(order);
//		orderService.deleteOrderAndItsOrderedItems(order);
//		System.out.println(bill);
//
	}
}
