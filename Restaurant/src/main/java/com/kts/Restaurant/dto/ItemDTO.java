package com.kts.Restaurant.dto;

public class ItemDTO {

	String name;
	int price;
	int cost;
	
	
	public ItemDTO() {
		super();
	}
	public ItemDTO(String name, int price, int cost) {
		super();
		this.name = name;
		this.price = price;
		this.cost = cost;
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
	@Override
	public String toString() {
		return "ItemDTO [name=" + name + ", price=" + price + ", cost=" + cost + "]";
	}
	
	
	
}
