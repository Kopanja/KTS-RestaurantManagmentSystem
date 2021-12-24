package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node
public class OrderedItem {

	@Id @GeneratedValue
	private Long id;
	
	@Relationship(type = "IS_ITEM", direction = Direction.OUTGOING)
	private Item item;
	
	private boolean prepared;

	
	
	public OrderedItem() {
		super();
	}

	

	public OrderedItem(Item item, boolean prepared) {
		super();
		this.item = item;
		this.prepared = prepared;
	}



	public OrderedItem(Long id, Item item, boolean prepared) {
		super();
		this.id = id;
		this.item = item;
		this.prepared = prepared;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Item getItem() {
		return item;
	}



	public void setItem(Item item) {
		this.item = item;
	}



	public boolean isPrepared() {
		return prepared;
	}



	public void setPrepared(boolean prepared) {
		this.prepared = prepared;
	}



	@Override
	public String toString() {
		return "OrderedItem [id=" + id + ", item=" + item + ", prepared=" + prepared + "]";
	}
	
	
	
}
