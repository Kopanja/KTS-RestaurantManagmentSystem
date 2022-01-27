package com.kts.Restaurant.security.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kts.Restaurant.model.User;
import com.kts.Restaurant.model.UsernamePasswordCredentials;
import com.kts.Restaurant.security.util.TokenUtils;
import com.kts.Restaurant.service.UserService;
import com.kts.Restaurant.service.UsernamePasswordCredentialsService;



@Component
public class JWTFilter extends OncePerRequestFilter {

	@Autowired
	private TokenUtils jwtUtil;
	
	@Autowired
	UsernamePasswordCredentialsService credentialService;
	
	@Autowired
	UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization");
		String username = null;
		String jwt = null;
		
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
			
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UsernamePasswordCredentials credentials = credentialService.findByUsername(username);
			if (credentials != null && jwtUtil.validateToken(jwt, credentials)) {
				User user = userService.findByUsername(username);
				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
				
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						credentials.getUsername(), null, authorities);
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			}else {
				User user = userService.findByGeneratedTokenSubject(username);
				if(user != null && jwtUtil.validateToken(jwt, user)) {
					List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
					authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
					
					
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							username, null, authorities);
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);	
				}
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
