package com.kts.Restaurant.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kts.Restaurant.constants.TableConstants;
import com.kts.Restaurant.model.Table;
import com.kts.Restaurant.constants.OrderConstants;
@ExtendWith(SpringExtension.class)
@DataNeo4jTest
@TestPropertySource("classpath:application-test.properties")
public class TableRepositoryTest {

	@Autowired
	TableRepository tableRepo;
	
	
	@Test
	public void testFindTableByOrderId() {
		Table table = tableRepo.findTableByOrderId(OrderConstants.DB_ORDER_ID);
		assertEquals(TableConstants.DB_TABLE_NAME, table.getName());
	}
}
