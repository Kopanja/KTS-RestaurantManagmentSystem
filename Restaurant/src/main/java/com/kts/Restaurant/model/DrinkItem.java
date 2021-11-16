package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class DrinkItem extends Item {

	public DrinkItem(String name, int price, int cost) {
		super(name,price,cost);
	}

	
}
