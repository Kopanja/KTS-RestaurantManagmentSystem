package com.kts.Restaurant.model.notiffication;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import com.kts.Restaurant.model.OrderedItem;
@Node
public class OrderNotiffication implements Notiffication {

	@Id @GeneratedValue
	private Long id;
	
	@Relationship(type = "HAS_ORDERED_ITEM", direction = Direction.OUTGOING)
	private List<OrderedItem> items;
	
	
	
	public OrderNotiffication(List<OrderedItem> items) {
		super();
		this.items = items;
	}


	public OrderNotiffication(Long id, List<OrderedItem> items) {
		super();
		this.id = id;
		this.items = items;
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


	@Override
	public String toString() {
		return "OrderNotiffication [id=" + id + ", items=" + items + "]";
	}
	
	
	

}
