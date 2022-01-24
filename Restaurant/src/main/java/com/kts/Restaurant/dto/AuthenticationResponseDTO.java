package com.kts.Restaurant.dto;

public class AuthenticationResponseDTO {
	private String jwt;
	
	private UserDTO user;

	public AuthenticationResponseDTO() {
		super();
	}

	public AuthenticationResponseDTO(String jwt, UserDTO user) {
		super();
		this.jwt = jwt;
		this.user = user;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	

}
