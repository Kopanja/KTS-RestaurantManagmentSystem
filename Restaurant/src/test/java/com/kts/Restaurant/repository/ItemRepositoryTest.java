package com.kts.Restaurant.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.kts.Restaurant.model.Item;

@RunWith(SpringRunner.class)
@DataNeo4jTest
@TestPropertySource("classpath:application-test.properties")
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository itemRepo;
	


	
	@Test
	public void findAllTest() {
		List<Item> items = itemRepo.findAll();
		System.out.println(items.size());
		assertTrue(items.size() == 69);
	}
	
	
	@Test
	public void findByNameTest() {
		String name = "Tiramisu";
		Item item = itemRepo.findByName(name);
		assertNotNull(item);
	}
	
	@Test
	public void findByCategoryNameTest() {
		String categoryName = "Coffe";
		List<Item> items = itemRepo.findByCategoryName(categoryName);
		assertTrue(items.size() == 4);
	}

}
