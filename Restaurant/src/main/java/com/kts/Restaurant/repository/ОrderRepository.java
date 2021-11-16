package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.Order;

@Repository
public interface ОrderRepository extends Neo4jRepository<Order, Long> {

}
