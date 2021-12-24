package com.kts.Restaurant.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.OrderedItem;

@Repository
public interface OrderedItemRepository extends Neo4jRepository<OrderedItem, Long> {
	
	@Query("MATCH (n:Order)-[:HAS]->(m:OrderedItem)-[r:IS_ITEM]->(i:DrinkItem)\r\n"
			+ "WHERE id(n) = $orderId\r\n"
			+ "RETURN m,r,i")
	List<OrderedItem> findDrinkOrderedItemByOrderId(Long orderId);

}
