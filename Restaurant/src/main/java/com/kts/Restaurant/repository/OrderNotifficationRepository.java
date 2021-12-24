package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.kts.Restaurant.model.notiffication.OrderNotiffication;


public interface OrderNotifficationRepository extends Neo4jRepository<OrderNotiffication, Long> {

}
