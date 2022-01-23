package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.PinCredentials;


@Repository
public interface PinCredentialsRepository extends Neo4jRepository<PinCredentials, Long> {

}
