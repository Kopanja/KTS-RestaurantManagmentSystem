package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.UsernamePasswordCredentials;



@Repository
public interface UsernamePasswordCredentialsRepository extends Neo4jRepository<UsernamePasswordCredentials, Long> {

	UsernamePasswordCredentials findByUsername(String username);

}
