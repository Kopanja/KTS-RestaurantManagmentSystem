package com.kts.Restaurant.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.kts.Restaurant.model.*;
import com.kts.Restaurant.repository.BillRepository;
import com.kts.Restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.dto.TableDTO;

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

	@Autowired
	UserRepository userRepository;

	@Autowired
	BillRepository billRepository;





	public Map<User, Double> getWaiterStatistics(String from, String to) throws ParseException {
		List<User> waiters = userRepository.getAllWaiters();
		Date fromDate = null;
		Date toDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


		if (from != null && !from.equals("")) {
			fromDate = dateFormat.parse(from);
		}
		if (to != null && !to.equals("")) {
			toDate = dateFormat.parse(to);
		}

		List<Bill> bills = billRepository.findAll();
		if(fromDate != null){
			for (Iterator<Bill> bill = bills.iterator(); bill.hasNext();) {
				Bill temp = bill.next();
				if (temp.getDate().before(fromDate)) {
					bill.remove();
				}
			}
		}

		if(toDate != null){
			for (Iterator<Bill> bill = bills.iterator(); bill.hasNext();) {
				Bill temp = bill.next();
				if (temp.getDate().after(toDate)) {
					bill.remove();
				}
			}
		}

		Map<Long, Double> idResult = new HashMap();

		for (User waiter: waiters) {
			idResult.put(waiter.getId(), 0.0);
		}

		for(Bill bill: bills) {
			Long key = bill.getWaiter().getId();
			if(!idResult.containsKey(key)) continue;
			double value = (double)idResult.get(key) + (bill.getPrice() - bill.getCost());
			idResult.put(key, value);
		}
		Map<User, Double> result = new HashMap();
		for(Long elemKey: idResult.keySet()) {
			for(User user: waiters) {
				if(user.getId() == elemKey) {
					result.put(user, idResult.get(elemKey));
				}
			}
		}

		return result;
	}
	
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
