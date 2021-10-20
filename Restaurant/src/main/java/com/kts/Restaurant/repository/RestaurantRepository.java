package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.Restaurant;

@Repository
public interface RestaurantRepository extends Neo4jRepository<Restaurant, Long>{

}
