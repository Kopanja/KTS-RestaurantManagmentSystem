package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node
public class BilledItem {
	
	@Id @GeneratedValue
	private Long id;
	
	@Relationship(type = "IS_ITEM", direction = Direction.OUTGOING)
	private Item item;

	
	
	
	public BilledItem() {
		super();
	}




	public BilledItem(Long id, Item item) {
		super();
		this.id = id;
		this.item = item;
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




	@Override
	public String toString() {
		return "BilledItem [id=" + id + ", item=" + item + "]";
	}
	
	
	
	

}
