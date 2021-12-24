package com.kts.Restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.model.OrderedItem;
import com.kts.Restaurant.model.notiffication.OrderNotiffication;
import com.kts.Restaurant.repository.OrderNotifficationRepository;


@Service
public class NotifficationService {
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@Autowired
	OrderNotifficationRepository orderNotifficationRepo;
	
	public void notifyBartender(List<OrderedItem> items) {
		
		OrderNotiffication notiffication = new OrderNotiffication(items);
		
		//notiffication = orderNotifficationRepo.save(notiffication);
		System.out.println(notiffication);
		messagingTemplate.convertAndSend("/topic/bartender", notiffication);
	}
	
	public void notifyPrivate(String username, Object message) {
		//ResponseMessage response = new ResponseMessage(message.getContent());
		//umesto new Object treba da se stavi objekat koji predstavlja response
		messagingTemplate.convertAndSend("/topic/message/" + username, new Object());
	}

}
