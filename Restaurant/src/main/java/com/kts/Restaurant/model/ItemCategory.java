package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class ItemCategory {
	
	@Id @GeneratedValue
	private Long id;

	private String type;
	
	private String categoryName;

	public ItemCategory() {
		super();
	}

	public ItemCategory(String type, String categoryName) {
		super();
		this.type = type;
		this.categoryName = categoryName;
	}

	public ItemCategory(Long id, String type, String categoryName) {
		super();
		this.id = id;
		this.type = type;
		this.categoryName = categoryName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ItemCategory [id=" + id + ", type=" + type + ", categoryName=" + categoryName + "]";
	}
	
	
	

}
