package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.stereotype.Indexed;


@Node
public abstract class Item {

	@Id @GeneratedValue
	private Long id;

	private String name;
	
	private String description;
	
	private int price;
	
	private int cost;

	
	
	public Item() {
		super();
	}
	
	

	public Item(String name, int price, int cost) {
		super();
		this.name = name;
		this.price = price;
		this.cost = cost;
	}



	public Item(Long id, String name, String description, int price, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.cost = cost;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", cost="
				+ cost + "]";
	}
	
	
	
}
