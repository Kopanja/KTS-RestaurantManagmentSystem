package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.kts.Restaurant.model.BilledItem;

public interface BilledItemRepository extends Neo4jRepository<BilledItem, Long> {

}
