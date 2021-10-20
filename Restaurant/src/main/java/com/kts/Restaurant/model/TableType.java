package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class TableType {

	@Id @GeneratedValue
	private Long id;
	
	private int numOfSeats;

	private String icon;
	
	private String name;
	
	public TableType() {
		super();
	}

	public TableType(Long id, int numOfSeats) {
		super();
		this.id = id;
		this.numOfSeats = numOfSeats;
	}

	
	public TableType(Long id, int numOfSeats, String icon) {
		super();
		this.id = id;
		this.numOfSeats = numOfSeats;
		this.icon = icon;
	}

	
	public TableType(Long id, int numOfSeats, String icon, String name) {
		super();
		this.id = id;
		this.numOfSeats = numOfSeats;
		this.icon = icon;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
}
