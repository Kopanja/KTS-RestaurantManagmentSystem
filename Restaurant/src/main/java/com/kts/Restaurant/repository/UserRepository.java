package com.kts.Restaurant.repository;

import com.kts.Restaurant.model.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.User;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAllByRole(Role role);

}
