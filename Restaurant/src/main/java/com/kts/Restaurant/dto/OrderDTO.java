package com.kts.Restaurant.dto;

import java.util.List;

public class OrderDTO {

	List<ItemDTO> items;

	public OrderDTO() {
		super();
	}

	public OrderDTO(List<ItemDTO> items) {
		super();
		this.items = items;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	
	
}
