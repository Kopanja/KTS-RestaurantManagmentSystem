package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public class User {

	@Id @GeneratedValue
	private Long id;
	
	private String username;
	
	private String role;

	public User() {
		super();
	}

	public User(Long id, String username, String role) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
