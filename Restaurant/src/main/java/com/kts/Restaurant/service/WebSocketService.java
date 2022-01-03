package com.kts.Restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.OrderDTO;

@Service
public class WebSocketService {
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	public void sendMessage(String topicSuffix) {
		messagingTemplate.convertAndSend("/topic/" + topicSuffix, "Default Message from WS");
	}
	
	public void sendDrinkOrder(Long orderId) {
		messagingTemplate.convertAndSend("/topic/bartender", orderId);
	}
	
	public void sendFoodOrder(Long orderId) {
		messagingTemplate.convertAndSend("/topic/cook", orderId);
	}
	
	public void sendOrderedItemChange(OrderDTO order) {
		messagingTemplate.convertAndSend("/topic/table", order);
	}

}
