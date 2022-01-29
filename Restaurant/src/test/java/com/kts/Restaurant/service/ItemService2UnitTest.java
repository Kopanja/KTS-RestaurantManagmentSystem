package com.kts.Restaurant.service;

import static com.kts.Restaurant.constants.ItemConstants.DB_ITEM_CATEGORY_NAME;
import static com.kts.Restaurant.constants.ItemConstants.DB_ITEM_COST;
import static com.kts.Restaurant.constants.ItemConstants.DB_ITEM_DESCRIPTION;
import static com.kts.Restaurant.constants.ItemConstants.DB_ITEM_NAME;
import static com.kts.Restaurant.constants.ItemConstants.DB_ITEM_PRICE;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.repository.ItemCategoryRepository;
import com.kts.Restaurant.repository.ItemRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemService2UnitTest {

	//@MockBean
	//ItemCategoryRepository itemCategoryRepository;

	@Autowired
	ItemService itemService;

	//@MockBean
	//ItemRepository itemRepository;

	@Test
	public void create_item_with_non_existing_category_name() {
		System.out.println("AAAAAAAAAAAAAAAAAAAA");
		ItemDTO itemDto = new ItemDTO(DB_ITEM_NAME, DB_ITEM_DESCRIPTION, DB_ITEM_PRICE, DB_ITEM_COST,
				DB_ITEM_CATEGORY_NAME);

		// when(itemCategoryRepository.findItemCategoryByCategoryName(DB_NEW_ITEM_CATEGORY_NAME)).thenReturn(null);

		// itemService.create(itemDto);
	}
}
