package com.kts.Restaurant.dto;

public class OrderedItemDTO {

	private Long id;
	private ItemDTO item;
	private boolean prepared;
	
	
	
	
	public OrderedItemDTO() {
		super();
	}




	public OrderedItemDTO(Long id,ItemDTO item, boolean prepared) {
		super();
		this.id = id;
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




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	@Override
	public String toString() {
		return "OrderedItemDTO [id=" + id + ", item=" + item + ", prepared=" + prepared + "]";
	}
	
	
	
	
}
