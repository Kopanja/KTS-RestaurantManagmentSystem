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

import com.kts.Restaurant.dto.PinCredentialsDTO;
import com.kts.Restaurant.dto.UsernamePasswordCredentialsDTO;
import com.kts.Restaurant.security.service.AuthenticationService;

@RestController
@RequestMapping(value="api/auth")
public class AuthenticationController {
	
	@Autowired
	AuthenticationService authService;
	
	@PostMapping(value = "/usrn-pass-login")
	@CrossOrigin()
	public ResponseEntity<String> usernameAndPasswordLogin(@RequestBody UsernamePasswordCredentialsDTO authenticationRequest,
			HttpServletResponse response) throws Exception {
		String jwt = null;
		
		try {
			jwt = authService.loginUsernamePassword(authenticationRequest);
		} catch (AuthenticationException e) {
			return new ResponseEntity<String>("Incorrect username or password", HttpStatus.FORBIDDEN);
		} 
		
		//final UserDetails userDetails = menagmentService.loadUserByUsername(authenticationRequest.getUsername());	
		//String jwt = jwtTokenUtil.createToken(userDetails);
		return new ResponseEntity<String>(jwt, HttpStatus.OK);
	}
	
	@PostMapping(value = "/pin-login")
	@CrossOrigin()
	public ResponseEntity<String> pinBasedLogin(@RequestBody PinCredentialsDTO authenticationRequest,
			HttpServletResponse response) throws Exception {
		String jwt = null;
		
		try {
			jwt = authService.loginPin(authenticationRequest);
		} catch (AuthenticationException e) {
			return new ResponseEntity<String>("Incorrect username or password", HttpStatus.FORBIDDEN);
		} 
		
		//final UserDetails userDetails = menagmentService.loadUserByUsername(authenticationRequest.getUsername());	
		//String jwt = jwtTokenUtil.createToken(userDetails);
		return new ResponseEntity<String>(jwt, HttpStatus.OK);
	}

}
