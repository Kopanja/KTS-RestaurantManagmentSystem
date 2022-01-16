package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
//Class used for initilazing of the DB data
@Node
public class GenericNode {

	@Id @GeneratedValue
	private Long id;

	
	public GenericNode() {
		super();
	}

	public GenericNode(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
