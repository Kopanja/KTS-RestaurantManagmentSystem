package com.kts.Restaurant.model;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node
public class Floor {

	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	@Relationship(type = "HAS_TABLE", direction = Direction.OUTGOING)
	private List<Table> tables;

	public Floor() {
		super();
	}

	public Floor(Long id, String name, List<Table> tables) {
		super();
		this.id = id;
		this.name = name;
		this.tables = tables;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	@Override
	public String toString() {
		return "Floor [id=" + id + ", name=" + name + ", tables=" + tables + "]";
	}
	
	
	
	
}
