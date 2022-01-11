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
	
	private String name;
	
	private int x;
	
	private int y;
	
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


	


	public Table(String name, int x, int y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}


	public Table(Long id, int x, int y, TableType type, Order order) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.type = type;
		this.order = order;
	}




	public Table(Long id, int x, int y, String name) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.name = name;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Table [id=" + id + ", name=" + name + ", x=" + x + ", y=" + y + ", type=" + type + ", order=" + order
				+ "]";
	}
	
	
	
}
