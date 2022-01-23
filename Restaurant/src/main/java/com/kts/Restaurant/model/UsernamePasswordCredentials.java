package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class UsernamePasswordCredentials extends Credentials {
	
	private String username;
	private String password;
	
	
	
	public UsernamePasswordCredentials() {
		super();
	}



	public UsernamePasswordCredentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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



	@Override
	public String toString() {
		return "UsernamePasswordCredentials [username=" + username + ", password=" + password + "]";
	}
	
	
	

}
