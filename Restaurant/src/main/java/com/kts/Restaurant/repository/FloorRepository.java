package com.kts.Restaurant.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.Floor;


@Repository
public interface FloorRepository extends Neo4jRepository<Floor, Long> {
	
	
	public Floor findByName(String name);
}
