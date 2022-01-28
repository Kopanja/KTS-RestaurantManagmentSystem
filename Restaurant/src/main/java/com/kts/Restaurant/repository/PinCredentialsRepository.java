package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.PinCredentials;


@Repository
public interface PinCredentialsRepository extends Neo4jRepository<PinCredentials, Long> {

	@Query("MATCH (u:User)-[:HAS_CREDENTIALS]->(c:PinCredentials)\r\n"
			+ "WHERE id(u)=$id\r\n"
			+ "RETURN c")
	PinCredentials findByUserId(Long id);

}
