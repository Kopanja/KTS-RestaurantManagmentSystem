package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.kts.Restaurant.model.TableType;


public interface TableTypeRepository  extends Neo4jRepository<TableType, Long> {

}
