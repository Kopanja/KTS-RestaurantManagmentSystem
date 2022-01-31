package com.kts.Restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import com.kts.Restaurant.model.User;
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
		UsernamePasswordCredentials cred = credRepo.findByUsername(username);
		if(cred != null) {
			throw new UserWithUsernameAlreadyExistsException();
		}
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
		return credRepo.save(credentials);
	}

	public UsernamePasswordCredentials findByUserId(Long userId) {
		return credRepo.findByUserId(userId);
	}

	public void delete(UsernamePasswordCredentials oldCredentials) {
		credRepo.delete(oldCredentials);
	}
	
	
}
