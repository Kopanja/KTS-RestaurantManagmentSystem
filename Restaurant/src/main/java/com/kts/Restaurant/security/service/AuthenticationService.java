package com.kts.Restaurant.security.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.AuthenticationResponseDTO;
import com.kts.Restaurant.dto.PinCredentialsDTO;
import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.dto.UsernamePasswordCredentialsDTO;
import com.kts.Restaurant.model.PinCredentials;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.security.util.TokenUtils;
import com.kts.Restaurant.service.UserService;

@Service
public class AuthenticationService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	public void encode(String s) {
		System.out.println(passwordEncoder.encode(s));
		
	}
	
	
	public AuthenticationResponseDTO loginUsernamePassword(UsernamePasswordCredentialsDTO authenticationRequest) throws AuthenticationException {
		
		Authentication authentication = null;
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword());
		authentication = authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		User user = userService.findByUsername(authenticationRequest.getUsername());
		List<GrantedAuthority> authorities = createAuthorities(user);
		String jwt = tokenUtils.createToken(authToken, authorities);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstname(user.getFirstname());
		userDTO.setLastname(user.getLastname());
		
		
		return new AuthenticationResponseDTO(jwt, userDTO);
	}
	
	private List<GrantedAuthority> createAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
		return authorities;
		
	}


	public AuthenticationResponseDTO loginPin(PinCredentialsDTO authenticationRequest) {
		Authentication authentication = null;
		String jwt = null;
		String pin = authenticationRequest.getPin();
		User user = userService.findByPin(pin);
		UserDTO userDTO = null;
		if(user != null) {
			String username = userService.generateTokenSubjectForPinUser(user);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,pin);
			authentication = authenticationManager.authenticate(authToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			List<GrantedAuthority> authorities = createAuthorities(user);
			jwt = tokenUtils.createToken(authToken, authorities);
			System.out.println(jwt);
			System.out.println(user);
			userDTO = new UserDTO();
			userDTO.setFirstname(user.getFirstname());
			userDTO.setLastname(user.getLastname());
			
		}
		return new AuthenticationResponseDTO(jwt, userDTO);
		
		
		
		 
	}
	
	

}
