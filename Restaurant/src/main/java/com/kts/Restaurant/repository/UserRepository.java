package com.kts.Restaurant.repository;

import com.kts.Restaurant.model.OrderedItem;
import com.kts.Restaurant.model.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.User;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

	 @Query("MATCH (n:User)-[a:HAS_CREDENTIALS]->(c:UsernamePasswordCredentials)\n" +
	            "WHERE c.username = $username\n"
	            + "WITH n,a,c\n"
	            + "MATCH (n)-[b:HAS_ROLE]->(r:Role)" +
	            "RETURN n,a,c,b,r")
    User findByUsername(String username);

	 @Query("MATCH (n:User)-[a:HAS_CREDENTIALS]->(c:PinCredentials) \r\n"
	 		+ "MATCH (n)-[b:HAS_ROLE]->(r:Role)\r\n"
	 		+ "WHERE n.firstname + n.lastname + r.role + toString(id(n)) = $tokenSubject\r\n"
	 		+ "RETURN n,a,c,b,r")
	 User findByGeneratedTokenSubject(String tokenSubject);

    @Query("MATCH (n:User)-[a:HAS_ROLE]->(r:Role)\n" +
            "WHERE r.role = $role AND n.active = true\n" +
            "RETURN n,a,r")
    List<User> findAllByRole(String role);

    
    
    
    @Query("MATCH (n:User)-[a:HAS_CREDENTIALS]->(c:PinCredentials)\n" +
            "MATCH (n)-[b:HAS_ROLE]->(r:Role)\n" +
            "RETURN n,a,c,b,r")
	List<User> getAllPinUsers();

	@Query("MATCH (n:User)-[b:HAS_ROLE]->(r:Role)\n" +
			"WHERE r.role = 'WAITER'" +
			"RETURN n,r")
	List<User> getAllWaiters();



}
