package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;


@Node
public abstract class Item {

	@Id @GeneratedValue
	private Long id;

	private String name;
	
	private String description;
	
	private String imgPath;
	
	private String alergens;
	
	private String prepTime;
	
	@Relationship(type = "HAS_CATEGORY", direction = Direction.OUTGOING)
	public ItemCategory category;
	
	private boolean active;
	
	private int price;
	
	private int cost;

	
	
	public Item() {
		super();
	}
	
	

	public Item(String name, int price, int cost) {
		super();
		this.name = name;
		this.price = price;
		this.cost = cost;
	}


	

	



	public Item(Long id, String name, String description, String imgPath, String alergens, ItemCategory category,
			boolean active, int price, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imgPath = imgPath;
		this.alergens = alergens;
		this.category = category;
		this.active = active;
		this.price = price;
		this.cost = cost;
	}



	public Item(String name, String description, ItemCategory category, boolean active, int price, int cost) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.active = active;
		this.price = price;
		this.cost = cost;
	}



	public Item(Long id, String name, String description, int price, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.cost = cost;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}



	public ItemCategory getCategory() {
		return category;
	}



	public void setCategory(ItemCategory category) {
		this.category = category;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public String getImgPath() {
		return imgPath;
	}



	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}



	public String getAlergens() {
		return alergens;
	}



	public void setAlergens(String alergens) {
		this.alergens = alergens;
	}



	public String getPrepTime() {
		return prepTime;
	}



	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}



	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", imgPath=" + imgPath
				+ ", alergens=" + alergens + ", category=" + category + ", active=" + active + ", price=" + price
				+ ", cost=" + cost + "]";
	}



	



	
	
}
