package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kts.Restaurant.dto.BillWaiterStatisticsDTO;
import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.model.*;
import com.kts.Restaurant.util.mapper.BillMapper;
import com.kts.Restaurant.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Bill bill = new Bill(null, price, cost,date, items, order.getUser());
		bill = this.save(bill);
		return bill;
	}

	public List<BillWaiterStatisticsDTO> getAllBills() {
		List<BillWaiterStatisticsDTO> dtos = new ArrayList<>();
		List<Bill> bills = billRepo.findAll();

		if(bills.size() == 0){
			return null;
		}
		BillMapper billMapper = new BillMapper();
		for (Bill bill: bills) {
			dtos.add(billMapper.toDto(bill));
		}

		return dtos;
	}
	
	
	public Bill save(Bill bill) {
		return billRepo.save(bill);
	}
	
	

}
