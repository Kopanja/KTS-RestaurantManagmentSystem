package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.model.Bill;
import com.kts.Restaurant.model.BilledItem;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.OrderedItem;
import com.kts.Restaurant.repository.BillRepository;

@Service
public class BillService {
	
	@Autowired
	BillRepository billRepo;
	
	@Autowired
	BilledItemService billedItemService;
	
	public Bill createBillFromOrder(Order order){
		ArrayList<BilledItem> items = new ArrayList<BilledItem>();
		double price = 0;
		double cost = 0;
		Date date = new Date();
		for(OrderedItem oi : order.getItems()) {
			Item item = oi.getItem();
			BilledItem billedItem = billedItemService.save(new BilledItem(null,item));
			items.add(billedItem);
			price += item.getPrice();
			cost += item.getCost();
		}
		Bill bill = new Bill(null, price, cost,date, items);
		bill = this.save(bill);
		return bill;
	}
	
	
	public Bill save(Bill bill) {
		return billRepo.save(bill);
	}
	
	

}
