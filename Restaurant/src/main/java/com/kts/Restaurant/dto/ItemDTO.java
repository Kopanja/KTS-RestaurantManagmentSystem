package com.kts.Restaurant.dto;

public class ItemDTO {

	private String name;
	private String description;
	private int price;
	private int cost;
	private String itemCategoryName;


	public ItemDTO() {
		super();
	}

	public ItemDTO(String name, int price, int cost) {
		super();
		this.name = name;
		this.price = price;
		this.cost = cost;
	}
	public ItemDTO(String name, int price, int cost, String description) {
		super();
		this.name = name;
		this.price = price;
		this.cost = cost;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ItemDTO [name=" + name + ", price=" + price + ", cost=" + cost + "]";
	}
	
	
	
}
