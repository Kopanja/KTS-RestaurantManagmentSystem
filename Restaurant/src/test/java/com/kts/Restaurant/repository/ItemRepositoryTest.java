package com.kts.Restaurant.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.kts.Restaurant.model.FoodItem;
import com.kts.Restaurant.model.Item;

//@RunWith(SpringRunner.class)
@DataNeo4jTest
@TestPropertySource("classpath:application-test.properties")
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository itemRepo;
	
	@BeforeEach
	public void setup() {
		System.out.println("AAAAAAAAAAAAAAAAAAA");
		FoodItem food = new FoodItem();
		food.setName("FoodTest2");
		food.setPrice(780);
		food.setCost(200);
		food.setDescription("Hrana za testiranje");
		itemRepo.save(food);
	}
	
	@Test
	public void findAllTest() {
		System.out.println("USAOOOO");
		List<Item> items = itemRepo.findAll();
		for(Item i : items) {
			System.out.println(i);
		}
		assertTrue(items.size()>0);
	}

}
