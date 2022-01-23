package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String firstname;

	private String lastname;

	@Relationship(type = "HAS_CREDENTIALS", direction = Relationship.Direction.OUTGOING)
	private Credentials credentials;
	
	@Relationship(type = "HAS_ROLE", direction = Relationship.Direction.OUTGOING)
	private Role role;

	@Relationship(type = "HAS_SALARY", direction =  Relationship.Direction.OUTGOING)
	private List<Salary> salaries;

	private Boolean active;

	public User() {
		super();
	}

	public User(Long id, String firstname, String lastname, Role role, List<Salary> salaries, Boolean active) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.salaries = salaries;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", credentials=" + credentials
				+ ", role=" + role + ", salaries=" + salaries + ", active=" + active + "]";
	}

	

	
}