package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.OrderedItem;

@Repository
public interface OrderedItemRepository extends Neo4jRepository<OrderedItem, Long> {

}
