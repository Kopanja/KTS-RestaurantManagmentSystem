package com.kts.Restaurant.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.kts.Restaurant.model.Table;

@Repository
public interface TableRepository extends Neo4jRepository<Table, Long> {

	@Query("MATCH (n)\r\n"
			+ "DETACH DELETE n")
	public void deleteEveryNodeAndRel();
	
	
	public Table findByName(String name);
	
	
	@Query("CREATE (tl:TableType {icon : \"tableLarge.png\", name : \"6seat\", numOfSeats : 6})\r\n"
			+ "CREATE (tm:TableType {icon : \"tableMedium.png\", name : \"4seat\", numOfSeats : 4})\r\n"
			+ "CREATE (ts:TableType {icon : \"tableSmall.png\", name : \"2seat\", numOfSeats : 2})\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "CREATE(:Item:FoodItem {cost : 350, description : \"This is food\", name : \"Delicious food\", price : 1000})\r\n"
			+ "CREATE(:Item:DrinkItem {cost : 59, description : \"This is a drink\", name : \"Refreshing drink\", price : 150})\r\n"
			+ "\r\n"
			+ "CREATE (ts1:Table {x : 175, y : 170})\r\n"
			+ "CREATE (ts2:Table {x : 421, y : 143})\r\n"
			+ "CREATE (ts3:Table {x : 174, y : 354})\r\n"
			+ "\r\n"
			+ "CREATE (tm1:Table {x : 178, y : 11})\r\n"
			+ "CREATE (tm2:Table {x : 421, y : 1})\r\n"
			+ "\r\n"
			+ "CREATE (tl1:Table {x : 0, y : 203})\r\n"
			+ "CREATE (tl2:Table {x : 0, y : 19})\r\n"
			+ "CREATE (tl3:Table {x : 421, y : 327})\r\n"
			+ "\r\n"
			+ "MERGE (ts1)-[:IS_TYPE]->(ts)\r\n"
			+ "MERGE (ts2)-[:IS_TYPE]->(ts)\r\n"
			+ "MERGE (ts3)-[:IS_TYPE]->(ts)\r\n"
			+ "\r\n"
			+ "MERGE (tm1)-[:IS_TYPE]->(tm)\r\n"
			+ "MERGE (tm2)-[:IS_TYPE]->(tm)\r\n"
			+ "\r\n"
			+ "MERGE (tl1)-[:IS_TYPE]->(tl)\r\n"
			+ "MERGE (tl2)-[:IS_TYPE]->(tl)\r\n"
			+ "MERGE (tl3)-[:IS_TYPE]->(tl)")
	public void createDBData();
}
