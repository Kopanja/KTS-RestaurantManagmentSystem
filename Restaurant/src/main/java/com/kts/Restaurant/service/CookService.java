package com.kts.Restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.OrderDTO;

@Service
public class CookService {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderedItemService orderedItemService;
	
	@Autowired
	WebSocketService webSocketService;
	
	
	public List<OrderDTO> getOrdersForCook(){
		return orderService.getAllOrdersWithNotPreparedFoodItems();
	}
	
	public void foodMade(Long orderedItemId, OrderDTO order) {
		orderedItemService.orderedItemChangePrepared(orderedItemId);
		String tableName = order.getTableName();
		OrderDTO dto = orderService.getOrderByTableName(tableName);
		webSocketService.sendOrderedItemChange(dto);
		
	}

}
