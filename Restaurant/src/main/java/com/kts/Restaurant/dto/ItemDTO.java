package com.kts.Restaurant.dto;

public class ItemDTO {

	private String name;
	private String description;
	private int price;
	private int cost;
	private String itemCategoryName;
	private String imgPath;
	private String alergens;

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

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
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

	private String prepTime;


	public ItemDTO() {
		super();
	}

	public ItemDTO(String name, int price, int cost) {
		super();
		this.name = name;
		this.price = price;
		this.cost = cost;
	}
	public ItemDTO(String name, int price, int cost, String description) {
		super();
		this.name = name;
		this.price = price;
		this.cost = cost;
		this.description = description;
	}
	
	
	
	public ItemDTO(String name, String description, int price, int cost, String itemCategoryName, String imgPath,
			String alergens, String prepTime) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.cost = cost;
		this.itemCategoryName = itemCategoryName;
		this.imgPath = imgPath;
		this.alergens = alergens;
		this.prepTime = prepTime;
	}

	public ItemDTO(String name, String description, int price, int cost, String itemCategoryName) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.cost = cost;
		this.itemCategoryName = itemCategoryName;
	}

	@Override
	public String toString() {
		return "ItemDTO{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", cost=" + cost +
				", itemCategoryName='" + itemCategoryName + '\'' +
				", imgPath='" + imgPath + '\'' +
				", alergens='" + alergens + '\'' +
				", prepTime='" + prepTime + '\'' +
				'}';
	}
}
