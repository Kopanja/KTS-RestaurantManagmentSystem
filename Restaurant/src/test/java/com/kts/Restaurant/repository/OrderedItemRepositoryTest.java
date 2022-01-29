package com.kts.Restaurant.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.kts.Restaurant.constants.OrderConstants;
import com.kts.Restaurant.model.OrderedItem;

@RunWith(SpringRunner.class)
@DataNeo4jTest
@TestPropertySource("classpath:application-test.properties")
public class OrderedItemRepositoryTest {

	@Autowired
	OrderedItemRepository orderedItemRepo;
	
	@Test
	public void testFindDrinkOrderedItemByOrderId() {
		List<OrderedItem> foundDrinkItems = orderedItemRepo.findDrinkOrderedItemByOrderId(OrderConstants.DB_ORDER_ID);
		System.out.println(foundDrinkItems.size());
		assertEquals(OrderConstants.DB_ORDER_NUM_OF_DRINK_ITEMS, foundDrinkItems.size());
	}
	
	@Test
	public void testFindFoodOrderedItemByOrderId() {
		List<OrderedItem> foundFoodItems = orderedItemRepo.findFoodOrderedItemByOrderId(OrderConstants.DB_ORDER_ID);
		System.out.println(foundFoodItems.size());
		assertEquals(OrderConstants.DB_ORDER_NUM_OF_FOOD_ITEMS, foundFoodItems.size());
	}
}
