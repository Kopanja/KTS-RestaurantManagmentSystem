package com.kts.Restaurant.repository;

import com.kts.Restaurant.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.kts.Restaurant.model.Bill;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;


public interface BillRepository extends Neo4jRepository<Bill, Long> {
    @Query("MATCH (n:Bill)-[a:HAS_CREDENTIALS]->(c:PinCredentials)\n" +
            "MATCH (n)-[b:HAS_ROLE]->(r:Role)\n" +
            "WHERE r.role = 'WAITER'" +
            "RETURN n,a,c,b,r")
    List<User> getAllWaiters();
}
