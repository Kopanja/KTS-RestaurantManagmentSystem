package com.kts.Restaurant.dto;

public class TableDTO {

	private Long tableId;
	private Long typeId;
	private String name;
	private int x;
	private int y;
	private int numOfSeats;
	private String icon;
	private OrderDTO order;
	
	public TableDTO() {
		super();
	}


	public TableDTO(Long tableId, Long typeId, int x, int y, int numOfSeats, String icon,String name) {
		super();
		this.tableId = tableId;
		this.typeId = typeId;
		this.x = x;
		this.y = y;
		this.numOfSeats = numOfSeats;
		this.icon = icon;
		this.name = name;
	}


	
	public TableDTO(Long tableId, Long typeId, int x, int y, int numOfSeats, String icon,
			OrderDTO order, String name) {
		super();
		this.tableId = tableId;
		this.typeId = typeId;
		this.x = x;
		this.y = y;
		this.numOfSeats = numOfSeats;
		this.icon = icon;
		this.order = order;
		this.name = name;
	}


	public Long getTableId() {
		return tableId;
	}


	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}


	public Long getTypeId() {
		return typeId;
	}


	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
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


	
	public OrderDTO getOrder() {
		return order;
	}


	public void setOrder(OrderDTO order) {
		this.order = order;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "TableDTO [tableId=" + tableId + ", typeId=" + typeId + ", name=" + name + ", x=" + x + ", y=" + y
				+ ", numOfSeats=" + numOfSeats + ", icon=" + icon + ", order=" + order + "]";
	}

	
	
	
	
	
	
}
