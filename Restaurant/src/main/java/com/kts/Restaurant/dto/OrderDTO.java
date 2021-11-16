package com.kts.Restaurant.dto;

import java.util.List;

public class OrderDTO {

	List<OrderedItemDTO> items;

	public OrderDTO() {
		super();
	}

	public OrderDTO(List<OrderedItemDTO> items) {
		super();
		this.items = items;
	}

	public List<OrderedItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderedItemDTO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderDTO [items=" + items + "]";
	}
	
	
	
}
