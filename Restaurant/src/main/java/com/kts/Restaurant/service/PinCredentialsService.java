package com.kts.Restaurant.service;

import com.kts.Restaurant.exceptions.PinAlreadyExists;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.model.PinCredentials;
import com.kts.Restaurant.repository.PinCredentialsRepository;

@Service
public class PinCredentialsService {

	@Autowired
	PinCredentialsRepository pinRepo;

	@Autowired
	UserRepository userRepository;
	
	public PinCredentials create(String pin) {
		if (this.doesPinExist(pin)) {
			throw new PinAlreadyExists();
		}
		PinCredentials credentials = new PinCredentials(pin);
		return pinRepo.save(credentials);
	}
	
	public PinCredentials findByUserId(Long id) {
		return pinRepo.findByUserId(id);
	}

	public void delete(PinCredentials oldCredentials) {
		pinRepo.delete(oldCredentials);
	}


	public boolean doesPinExist(String pin) {
		System.out.println(pin);
		for(User user : userRepository.getAllPinUsers()) {
			PinCredentials userPin = (PinCredentials) user.getCredentials();
			if(BCrypt.checkpw(pin, userPin.getPin())){
				return true;
			}
		}
		return false;
	}
}
