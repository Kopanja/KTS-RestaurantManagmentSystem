package com.kts.Restaurant.model;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node
public class Order {

	@Id @GeneratedValue
	private Long id;
	
	@Relationship(type = "HAS", direction = Direction.OUTGOING)
	public List<OrderedItem> items;
	
	@Relationship(type = "ORDERED_BY", direction = Direction.OUTGOING)
	public User user;

	
	
	public Order() {
		super();
	}


	

	public Order(List<OrderedItem> items) {
		super();
		this.items = items;
	}




	public Order(Long id, List<OrderedItem> items, User user) {
		super();
		this.id = id;
		this.items = items;
		this.user = user;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public List<OrderedItem> getItems() {
		return items;
	}



	public void setItems(List<OrderedItem> items) {
		this.items = items;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}




	@Override
	public String toString() {
		return "Order [id=" + id + ", items=" + items + ", user=" + user + "]";
	}
	
	
	
}
