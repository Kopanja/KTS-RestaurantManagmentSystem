package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.kts.Restaurant.model.Table;


public interface TableRepository extends Neo4jRepository<Table, Long> {

}
