package com.kts.Restaurant.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.Table;

@Repository
public interface TableRepository extends Neo4jRepository<Table, Long> {

	
	
	public Table findByName(String name);
	
	
	@Query("MATCH (n:Table)-[:HAS_ORDER]->(o:Order)\r\n"
			+ "WHERE id(o) = $orderId\r\n"
			+ "RETURN n")
	public Table findTableByOrderId(Long orderId);
	






	
}
