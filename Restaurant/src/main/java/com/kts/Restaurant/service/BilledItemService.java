package com.kts.Restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.model.BilledItem;
import com.kts.Restaurant.repository.BilledItemRepository;

@Service
public class BilledItemService {

	@Autowired
	BilledItemRepository billedItemRepo;
	
	
	public BilledItem save(BilledItem item) {
		return billedItemRepo.save(item);
	}
}
