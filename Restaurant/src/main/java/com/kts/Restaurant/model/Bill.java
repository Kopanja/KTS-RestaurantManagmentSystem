package com.kts.Restaurant.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node
public class Bill {
	
	@Id @GeneratedValue
	private Long id;
	
	private double price;
	
	private double cost;
	
	private Date date;
	
	@Relationship(type = "BILLED_ITEM", direction = Direction.OUTGOING)
	public List<BilledItem> items;

	
	
	
	public Bill() {
		super();
	}




	public Bill(Long id, double price, double cost, Date date, List<BilledItem> items) {
		super();
		this.id = id;
		this.price = price;
		this.cost = cost;
		this.date = date;
		this.items = items;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public double getCost() {
		return cost;
	}




	public void setCost(double cost) {
		this.cost = cost;
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	public List<BilledItem> getItems() {
		return items;
	}




	public void setItems(List<BilledItem> items) {
		this.items = items;
	}




	@Override
	public String toString() {
		return "Bill [id=" + id + ", price=" + price + ", cost=" + cost + ", date=" + date + ", items=" + items + "]";
	}
	
	
	

}
