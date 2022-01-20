package com.kts.Restaurant.repository;

import com.kts.Restaurant.model.OrderedItem;
import com.kts.Restaurant.model.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.User;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    User findByUsername(String username);

//    MATCH (n:User)-[a:HAS_ROLE]->(r:Role)
//            WHERE r.role = $role AND n.active
//            RETURN n,a,r

    @Query("MATCH (n:User)-[a:HAS_ROLE]->(r:Role)\n" +
            "WHERE r.role = $role AND n.active = true\n" +
            "RETURN n,a,r")
    List<User> findAllByRole(String role);


//    MATCH (n:User)-[a:HAS_ROLE]->(r:Role)
//    WHERE r.role = $role AND n.active
//    RETURN n,a,r
//
//    MATCH (parentD)-[:CONTAINS]->(childD:Decision)-[ru:CREATED_BY]->(u:User)
//    WHERE id(parentD) = {decisionId}
//    MATCH (childD)-[rdc:DECISION_CHARACTERISTIC]->(characteristic:Characteristic)
//    WHERE  (id(characteristic) = 138 AND (15000.32 < rdc.value < 50000.32))
//    OR (id(characteristic) = 139 AND (rdc.value = 'Commercial'))
//    WITH childD, ru, u
//    RETURN childD
}
