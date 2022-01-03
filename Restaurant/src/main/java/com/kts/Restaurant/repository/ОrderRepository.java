package com.kts.Restaurant.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.Order;

@Repository
public interface ОrderRepository extends Neo4jRepository<Order, Long> {
	
	@Query("MATCH (n:Order)-[r1:HAS]->(m:OrderedItem)-[r2:IS_ITEM]->(i:DrinkItem)\r\n"
			+ "RETURN n,collect(r1),collect(m),collect(r2),collect(i)")
	List<Order> getAllOrdersWithDrinkItems();
	
	@Query("MATCH (t:Table)-[:HAS_ORDER]->(n:Order)-[r1:HAS]->(m:OrderedItem)-[r2:IS_ITEM]->(i:Item)\r\n"
			+ "WHERE t.name = $tableName\r\n"
			+ "RETURN n,collect(r1),collect(m),collect(r2),collect(i)")
	Order findByTableName(String tableName);

	@Query("MATCH (n:Order)-[r1:HAS]->(m:OrderedItem)-[r2:IS_ITEM]->(i:FoodItem)\r\n"
			+ "RETURN n,collect(r1),collect(m),collect(r2),collect(i)")
	List<Order> getAllOrdersWithFoodItems();

}
