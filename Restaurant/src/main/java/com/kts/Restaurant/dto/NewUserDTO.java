package com.kts.Restaurant.dto;

public class NewUserDTO {

	private UserDTO user;
	private String username;
	private String password;
	private String pin;
	
	
	
	public NewUserDTO() {
		super();
	}



	public NewUserDTO(UserDTO userDTO, String pin) {
		super();
		this.user = userDTO;
		this.pin = pin;
	}



	public NewUserDTO(UserDTO userDTO, String username, String password) {
		super();
		this.user = userDTO;
		this.username = username;
		this.password = password;
	}



	public NewUserDTO(UserDTO userDTO, String username, String password, String pin) {
		super();
		this.user = userDTO;
		this.username = username;
		this.password = password;
		this.pin = pin;
	}



	public UserDTO getUser() {
		return user;
	}



	public void setUser(UserDTO user) {
		this.user = user;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPin() {
		return pin;
	}



	public void setPin(String pin) {
		this.pin = pin;
	}



	@Override
	public String toString() {
		return "NewUserDTO [user=" + user + ", username=" + username + ", password=" + password + ", pin=" + pin + "]";
	}

	
	
	
}
