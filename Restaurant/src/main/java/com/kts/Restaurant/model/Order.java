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
	public List<Item> items;
	
	@Relationship(type = "ORDERED_BY", direction = Direction.OUTGOING)
	public User user;

	
	
	public Order() {
		super();
	}



	public Order(Long id, List<Item> items, User user) {
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



	public List<Item> getItems() {
		return items;
	}



	public void setItems(List<Item> items) {
		this.items = items;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
