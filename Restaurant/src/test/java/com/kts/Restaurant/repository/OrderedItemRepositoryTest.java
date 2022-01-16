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
import com.kts.Restaurant.model.OrderedItem;

@ExtendWith(SpringExtension.class)
@DataNeo4jTest
@TestPropertySource("classpath:application-test.properties")
public class OrderedItemRepositoryTest {

	@Autowired
	OrderedItemRepository orderedItemRepo;
	
	@Test
	public void testFindDrinkOrderedItemByOrderId() {
		List<OrderedItem> foundDrinkItems = orderedItemRepo.findDrinkOrderedItemByOrderId(OrderConstants.DB_ORDER_ID);
		assertEquals(OrderConstants.DB_ORDER_NUM_OF_DRINK_ITEMS, foundDrinkItems.size());
	}
	
	@Test
	public void testFindFoodOrderedItemByOrderId() {
		List<OrderedItem> foundDrinkItems = orderedItemRepo.findFoodOrderedItemByOrderId(OrderConstants.DB_ORDER_ID);
		assertEquals(OrderConstants.DB_ORDER_NUM_OF_FOOD_ITEMS, foundDrinkItems.size());
	}
}
