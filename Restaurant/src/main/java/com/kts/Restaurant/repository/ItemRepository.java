package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.Item;


@Repository
public interface ItemRepository extends Neo4jRepository<Item, Long> {

}
