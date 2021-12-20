package com.kts.Restaurant.repository;

import com.kts.Restaurant.model.Salary;
import com.kts.Restaurant.model.Table;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends Neo4jRepository<Salary, Long> {

}
