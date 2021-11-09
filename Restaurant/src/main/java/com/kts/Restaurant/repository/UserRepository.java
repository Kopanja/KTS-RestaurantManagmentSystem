package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.kts.Restaurant.model.User;

public interface UserRepository extends Neo4jRepository<User, Long> {

}
