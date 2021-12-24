package com.kts.Restaurant.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.OrderedItem;

@Repository
public interface OrderedItemRepository extends Neo4jRepository<OrderedItem, Long> {
	
	@Query("MATCH (order:Order)-[:HAS]->(item:OrderedItem)-[:IS_ITEM]->(i:DrinkItem) WHERE(id(order) = $orderId) RETURN item")
	public List<OrderedItem> findDrinksFromOrder(Long orderId);
	
	
	@Query("MATCH (order:Order)-[:HAS]->(item:OrderedItem)-[:IS_ITEM]->(i:FoodItem) WHERE(id(order) = $orderId) RETURN item")
	public List<OrderedItem> findFoodsFromOrder(Long orderId);

}
