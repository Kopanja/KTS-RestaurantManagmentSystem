package com.kts.Restaurant.dto;

public class ItemCategoryDTO {
	private Long id;
	private String type;
	private String categoryName;
	private String icon;
	
	
	
	public ItemCategoryDTO(String type, String categoryName, String icon) {
		super();
		this.type = type;
		this.categoryName = categoryName;
		this.icon = icon;
	}
	public ItemCategoryDTO(Long id, String type, String categoryName, String icon) {
		super();
		this.id = id;
		this.type = type;
		this.categoryName = categoryName;
		this.icon = icon;
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	

}
