package com.kts.Restaurant.dto;

import java.util.List;

public class OrderDTO {

	Long orderId;
	String tableName;
	List<OrderedItemDTO> items;

	public OrderDTO() {
		super();
	}

	public OrderDTO(List<OrderedItemDTO> items) {
		super();
		this.items = items;
	}
	
	public OrderDTO(Long orderId, String tableName, List<OrderedItemDTO> items) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.tableName = tableName;
	}

	
	public List<OrderedItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderedItemDTO> items) {
		this.items = items;
	}

	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", items=" + items + "]";
	}

	
	
	
}
