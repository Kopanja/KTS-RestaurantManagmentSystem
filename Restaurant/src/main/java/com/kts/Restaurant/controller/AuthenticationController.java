package com.kts.Restaurant.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kts.Restaurant.dto.AuthenticationResponseDTO;
import com.kts.Restaurant.dto.NewUserDTO;
import com.kts.Restaurant.dto.PinCredentialsDTO;
import com.kts.Restaurant.dto.UsernamePasswordCredentialsDTO;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.security.service.AuthenticationService;

@RestController
@RequestMapping(value="api/auth")
public class AuthenticationController {
	
	@Autowired
	AuthenticationService authService;
	
	@PostMapping(value = "/usrn-pass-login")
	@CrossOrigin()
	public ResponseEntity<?> usernameAndPasswordLogin(@RequestBody UsernamePasswordCredentialsDTO authenticationRequest,
			HttpServletResponse response) throws Exception {
		
		
		AuthenticationResponseDTO res = null;
		System.out.println(authenticationRequest.getUsername());
		System.out.println(authenticationRequest.getPassword());
		try {
			res = authService.loginUsernamePassword(authenticationRequest);
		} catch (AuthenticationException e) {
			return new ResponseEntity<String>("Incorrect username or password", HttpStatus.FORBIDDEN);
		} 
		
		//final UserDetails userDetails = menagmentService.loadUserByUsername(authenticationRequest.getUsername());	
		//String jwt = jwtTokenUtil.createToken(userDetails);
		
		return new ResponseEntity<AuthenticationResponseDTO>(res, HttpStatus.OK);
	}
	
	@PostMapping(value = "/pin-login")
	@CrossOrigin()
	public ResponseEntity<?> pinBasedLogin(@RequestBody PinCredentialsDTO authenticationRequest,
			HttpServletResponse response) throws Exception {
		AuthenticationResponseDTO res = null;
		try {
			res = authService.loginPin(authenticationRequest);
		} catch (AuthenticationException e) {
			return new ResponseEntity<String>("Incorrect username or password", HttpStatus.FORBIDDEN);
		} 
		
		//final UserDetails userDetails = menagmentService.loadUserByUsername(authenticationRequest.getUsername());	
		//String jwt = jwtTokenUtil.createToken(userDetails);
		return new ResponseEntity<AuthenticationResponseDTO>(res, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/register")
	@CrossOrigin()
	public ResponseEntity<?> register(@RequestBody NewUserDTO newUserDTO,
			HttpServletResponse response) throws Exception {
		System.out.println(newUserDTO);
		User newUser = authService.register(newUserDTO);
		if(newUser != null) {
			System.out.println(newUser);
			return new ResponseEntity<>(HttpStatus.CREATED);
			
			
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
