package com.kts.Restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.model.PinCredentials;
import com.kts.Restaurant.repository.PinCredentialsRepository;

@Service
public class PinCredentialsService {

	@Autowired
	PinCredentialsRepository pinRepo;
	
	
	public PinCredentials create(String pin) {
		PinCredentials credentials = new PinCredentials(pin);
		return pinRepo.save(credentials);
	}
	
	public PinCredentials findByUserId(Long id) {
		return pinRepo.findByUserId(id);
	}

	public void delete(PinCredentials oldCredentials) {
		pinRepo.delete(oldCredentials);
	}

}
