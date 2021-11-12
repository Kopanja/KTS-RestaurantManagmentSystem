package com.kts.Restaurant.dto;

public class TableTypeDTO {
	
	private Long id;
	
	private int numOfSeats;

	private String icon;
	
	private String name;

	
	public TableTypeDTO() {
		super();
	}

	public TableTypeDTO(int numOfSeats, String icon, String name) {
		super();
		this.numOfSeats = numOfSeats;
		this.icon = icon;
		this.name = name;
	}
	
	public TableTypeDTO(Long id, int numOfSeats, String icon, String name) {
		super();
		this.id = id;
		this.numOfSeats = numOfSeats;
		this.icon = icon;
		this.name = name;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
