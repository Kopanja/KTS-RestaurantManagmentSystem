package com.kts.Restaurant.security.util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.kts.Restaurant.model.PinCredentials;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.model.UsernamePasswordCredentials;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtils {

	@Value("secret")
	public String SECRET;

	@Value("36000")
	private int EXPIRES_IN;
	
	
	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
	
	

	
	
	public String createToken(UsernamePasswordAuthenticationToken authToken, List<GrantedAuthority> authorities) {
		Map<String, Object> claims = new HashMap<>();	
        claims.put("sub", authToken.getName());	
        claims.put("role", authorities);	
        claims.put("created", new Date(System.currentTimeMillis()));
        return Jwts.builder()
				.setClaims(claims)
				.setSubject(authToken.getName())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SIGNATURE_ALGORITHM, SECRET).compact();
        
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public Boolean validateToken(String token, UsernamePasswordCredentials credentials) {
		final String username = extractUsername(token);
		return (username.equals(credentials.getUsername()) && !isTokenExpired(token));
	}
	
	public boolean validateToken(String token, User user) {
		final String tokenSubject = extractUsername(token);
		String generatedSubject = user.getFirstname() + user.getLastname() + user.getRole().getRole() + user.getId();
		return (tokenSubject.equals(generatedSubject) && !isTokenExpired(token));
	}


	
	
}
