package com.kts.Restaurant.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.Item;


@Repository
public interface ItemRepository extends Neo4jRepository<Item, Long> {

	@Query("MATCH (i:Item)-[r:HAS_CATEGORY]->(c:ItemCategory)\r\n"
			+ "WHERE i.name = $name\r\n"
			+ "RETURN i,r,c")
	public Item findByName(String name);
	
	@Query("MATCH (i:Item)-[:HAS_CATEGORY]->(c:ItemCategory)\r\n"
			+ "WHERE c.categoryName = $categoryName\r\n"
			+ "RETURN i")
	public List<Item> findByCategoryName(String categoryName);
}
