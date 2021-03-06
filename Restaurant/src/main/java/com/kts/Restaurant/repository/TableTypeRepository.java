package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.TableType;

@Repository
public interface TableTypeRepository extends Neo4jRepository<TableType, Long> {

}
