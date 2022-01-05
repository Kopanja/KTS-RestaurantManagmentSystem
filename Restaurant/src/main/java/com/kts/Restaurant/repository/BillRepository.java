package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.kts.Restaurant.model.Bill;


public interface BillRepository extends Neo4jRepository<Bill, Long> {

}
