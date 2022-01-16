package com.kts.Restaurant.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.kts.Restaurant.constants.OrderConstants;
import com.kts.Restaurant.constants.TableConstants;
import com.kts.Restaurant.model.Order;

@ExtendWith(SpringExtension.class)
@DataNeo4jTest
@TestPropertySource("classpath:application-test.properties")
public class OrderRepositoryTest {
	
	@Autowired
	ОrderRepository orderRepo;
	
	@Test
	public void testFindByTableName() {
		Order order = orderRepo.findByTableName(TableConstants.DB_TABLE_NAME);
		assertEquals(OrderConstants.DB_ORDER_ID, order.getId());
		assertEquals(OrderConstants.DB_OREDER_NUM_OF_ITEMS, order.getItems().size());
	}
	
	@Test
	public void testGetAllOrdersWithDrinkItems() {
		List<Order> foundOrders = orderRepo.getAllOrdersWithDrinkItems();
		assertEquals(OrderConstants.DB_NUM_OF_OREDERS_WITH_DRINK_ITEMS, foundOrders.size());
	}
	
	@Test
	public void testGetAllOrdersWithFoodItems() {
		List<Order> foundOrders = orderRepo.getAllOrdersWithFoodItems();
		assertEquals(OrderConstants.DB_NUM_OF_OREDERS_WITH_FOOD_ITEMS, foundOrders.size());
	}

}
