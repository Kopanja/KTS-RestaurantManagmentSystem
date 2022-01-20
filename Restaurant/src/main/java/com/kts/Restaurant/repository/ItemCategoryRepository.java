package com.kts.Restaurant.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.kts.Restaurant.model.ItemCategory;


public interface ItemCategoryRepository extends Neo4jRepository<ItemCategory, Long> {

	@Query("MATCH (i:ItemCategory)"
			+ "WHERE i.type = 'Food'"
			+ "RETURN i")
	public List<ItemCategory> getFoodCategories();
	
	@Query("MATCH (i:ItemCategory)"
			+ "WHERE i.type = 'Drink'"
			+ "RETURN i")
	public List<ItemCategory> getDrinkCategories();

	public ItemCategory findItemCategoryByCategoryName(String categoryName);
}
