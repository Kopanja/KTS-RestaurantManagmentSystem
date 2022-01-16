package com.kts.Restaurant.repository;

import org.neo4j.graphdb.Entity;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.kts.Restaurant.model.GenericNode;



public interface DBTestRepository  extends Neo4jRepository<GenericNode, Long> {
	
	@Query("CREATE (tl:TableType {icon : \"tableLarge.png\", name : \"6seat\", numOfSeats : 6})\r\n"
			+ "CREATE (tm:TableType {icon : \"tableMedium.png\", name : \"4seat\", numOfSeats : 4})\r\n"
			+ "CREATE (ts:TableType {icon : \"tableSmall.png\", name : \"2seat\", numOfSeats : 2})\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "CREATE(:Item:FoodItem {cost : 350, description : \"This is food\", name : \"Delicious food\", price : 1000})\r\n"
			+ "CREATE(:Item:DrinkItem {cost : 59, description : \"This is a drink\", name : \"Refreshing drink\", price : 150})\r\n"
			+ "\r\n"
			+ "CREATE (f1:Floor {name: \"Floor1\"})\r\n"
			+ "CREATE (f2:Floor {name: \"Floor2\"})\r\n"
			+ "\r\n"
			+ "CREATE (ts1:Table {x : 175, y : 170, name: \"Table1\"})\r\n"
			+ "CREATE (ts2:Table {x : 421, y : 143, name: \"Table2\"})\r\n"
			+ "CREATE (ts3:Table {x : 174, y : 354, name: \"Table3\"})\r\n"
			+ "CREATE (ts4:Table {x : 0, y : 203, name: \"Table9\"})\r\n"
			+ "CREATE (ts5:Table {x : 175, y : 203, name: \"Table10\"})\r\n"
			+ "\r\n"
			+ "CREATE (tm1:Table {x : 178, y : 11, name: \"Table4\"})\r\n"
			+ "CREATE (tm2:Table {x : 421, y : 1, name: \"Table5\"})\r\n"
			+ "CREATE (tm3:Table {x : 421, y : 1, name: \"Table11\"})\r\n"
			+ "\r\n"
			+ "CREATE (tl1:Table {x : 0, y : 203, name: \"Table6\"})\r\n"
			+ "CREATE (tl2:Table {x : 0, y : 19, name: \"Table7\"})\r\n"
			+ "CREATE (tl3:Table {x : 421, y : 327, name: \"Table8\"})\r\n"
			+ "CREATE (tl4:Table {x : 421, y : 327, name: \"Table12\"})\r\n"
			+ "\r\n"
			+ "MERGE (ts1)-[:IS_TYPE]->(ts)\r\n"
			+ "MERGE (ts2)-[:IS_TYPE]->(ts)\r\n"
			+ "MERGE (ts3)-[:IS_TYPE]->(ts)\r\n"
			+ "MERGE (ts4)-[:IS_TYPE]->(ts)\r\n"
			+ "MERGE (ts5)-[:IS_TYPE]->(ts)\r\n"
			+ "\r\n"
			+ "MERGE (tm1)-[:IS_TYPE]->(tm)\r\n"
			+ "MERGE (tm2)-[:IS_TYPE]->(tm)\r\n"
			+ "MERGE (tm3)-[:IS_TYPE]->(tm)\r\n"
			+ "\r\n"
			+ "MERGE (tl1)-[:IS_TYPE]->(tl)\r\n"
			+ "MERGE (tl2)-[:IS_TYPE]->(tl)\r\n"
			+ "MERGE (tl3)-[:IS_TYPE]->(tl)\r\n"
			+ "MERGE (tl4)-[:IS_TYPE]->(tl)\r\n"
			+ "\r\n"
			+ "MERGE (f1)-[:HAS_TABLE]->(ts1)\r\n"
			+ "MERGE (f1)-[:HAS_TABLE]->(ts2)\r\n"
			+ "MERGE (f1)-[:HAS_TABLE]->(ts3)\r\n"
			+ "MERGE (f1)-[:HAS_TABLE]->(tm1)\r\n"
			+ "MERGE (f1)-[:HAS_TABLE]->(tm2)\r\n"
			+ "MERGE (f1)-[:HAS_TABLE]->(tl1)\r\n"
			+ "MERGE (f1)-[:HAS_TABLE]->(tl2)\r\n"
			+ "MERGE (f1)-[:HAS_TABLE]->(tl3)\r\n"
			+ "\r\n"
			+ "MERGE (f2)-[:HAS_TABLE]->(ts4)\r\n"
			+ "MERGE (f2)-[:HAS_TABLE]->(ts5)\r\n"
			+ "MERGE (f2)-[:HAS_TABLE]->(tl4)\r\n"
			+ "MERGE (f2)-[:HAS_TABLE]->(tm3)\r\n")	
	public void createDBData();
	
	
	@Query("MATCH (n)\r\n"
			+ "DETACH DELETE n")
	public void deleteEveryNodeAndRel();

}
