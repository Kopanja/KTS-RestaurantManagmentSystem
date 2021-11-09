package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.kts.Restaurant.model.Order;


public interface ОrderRepository extends Neo4jRepository<Order, Long> {

}
