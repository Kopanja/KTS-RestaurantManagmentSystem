package com.kts.Restaurant.model;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class PinCredentials extends Credentials {
	
	private String pin;

	public PinCredentials() {
		super();
	}

	public PinCredentials(String pin) {
		super();
		this.pin = pin;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	

}
