package com.kts.Restaurant.repository;

import com.kts.Restaurant.model.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends Neo4jRepository<Role, Long> {

    @Query("CREATE (:Role {role: 'COOK'} )" +
            "CREATE (:Role {role: 'WAITER'} ) " +
            "CREATE (:Role {role: 'BARTENDER'} ) " +
            "CREATE (:Role {role: 'MANAGER'} ) " +
            "CREATE (:Role {role: 'ADMIN'} ) ")
    void createRolesDB();


    @Query("MATCH (n:Role) RETURN n ")
    List<Role> getAll();

    Role findByRole(String role);
}
