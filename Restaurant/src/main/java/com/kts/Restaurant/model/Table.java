package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;


@Node
public class Table {

	@Id @GeneratedValue
	private Long id;
	
	private int x;
	
	private int y;
	
	@Relationship(type = "FROM", direction = Direction.OUTGOING)
	public Restaurant restaurant;
	
	@Relationship(type = "IS_TYPE", direction = Direction.OUTGOING)
	public TableType type;
	
	@Relationship(type = "HAS_ORDER", direction = Direction.OUTGOING)
	public Order order;
	
	

	
	
	
	public Table() {
		super();
	}


	public Table(Long id, int x, int y) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
	}


	public Table(Long id, int x, int y, Restaurant restaurant) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.restaurant = restaurant;
	}


	


	public Table(Long id, int x, int y, Restaurant restaurant, TableType type, Order order) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.restaurant = restaurant;
		this.type = type;
		this.order = order;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public int getX() {
		return x;
	}




	public void setX(int x) {
		this.x = x;
	}




	public int getY() {
		return y;
	}




	public void setY(int y) {
		this.y = y;
	}




	public Restaurant getRestaurant() {
		return restaurant;
	}




	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}




	public TableType getType() {
		return type;
	}




	public void setType(TableType type) {
		this.type = type;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
}
