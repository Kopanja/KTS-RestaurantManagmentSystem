package com.kts.Restaurant.dto;

public class OrderedItemDTO {

	private ItemDTO item;
	private boolean prepared;
	
	
	
	
	public OrderedItemDTO() {
		super();
	}




	public OrderedItemDTO(ItemDTO item, boolean prepared) {
		super();
		this.item = item;
		this.prepared = prepared;
	}




	public ItemDTO getItem() {
		return item;
	}




	public void setItem(ItemDTO item) {
		this.item = item;
	}




	public boolean isPrepared() {
		return prepared;
	}




	public void setPrepared(boolean prepared) {
		this.prepared = prepared;
	}
	
	
	
	
}
