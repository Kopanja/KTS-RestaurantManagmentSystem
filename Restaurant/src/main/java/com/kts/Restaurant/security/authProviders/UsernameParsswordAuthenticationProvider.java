package com.kts.Restaurant.security.authProviders;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.model.PinCredentials;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.model.UsernamePasswordCredentials;
import com.kts.Restaurant.service.UserService;
import com.kts.Restaurant.service.UsernamePasswordCredentialsService;

@Service
public class UsernameParsswordAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		UsernamePasswordAuthenticationToken token = null;

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user = userService.findByUsername(username);
		if (user != null) {
			UsernamePasswordCredentials credentials = (UsernamePasswordCredentials) user.getCredentials();
			if (username.equals(credentials.getUsername()) && BCrypt.checkpw(password, credentials.getPassword())) {
				token = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword(),
						new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("username not found");
			}
		}else {
			user = userService.findByPin(password);
			if(user != null) {
				PinCredentials credentials = (PinCredentials) user.getCredentials();
				if (username.equals(userService.generateTokenSubjectForPinUser(user)) && BCrypt.checkpw(password, credentials.getPin())) {
					token = new UsernamePasswordAuthenticationToken(username, credentials.getPin(),
							new ArrayList<>());
				}
			} else {
				throw new UsernameNotFoundException("pin not found");
			}
			
		}
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
