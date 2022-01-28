package com.kts.Restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.model.UsernamePasswordCredentials;
import com.kts.Restaurant.repository.UsernamePasswordCredentialsRepository;

@Service
public class UsernamePasswordCredentialsService {

	@Autowired
	UsernamePasswordCredentialsRepository credRepo;

	public UsernamePasswordCredentials findByUsername(String username) {
		UsernamePasswordCredentials cred = credRepo.findByUsername(username);
		System.out.println(cred);
		return cred;
	}
	
	public UsernamePasswordCredentials create(String username, String password) {
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
		return credRepo.save(credentials);
	}
	
	
}
