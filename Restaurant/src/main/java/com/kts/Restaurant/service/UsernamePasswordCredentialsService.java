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
		// TODO Auto-generated method stub
		UsernamePasswordCredentials cred = credRepo.findByUsername(username);
		System.out.println(cred);
		return cred;
	}
	
	
}
