package com.kts.Restaurant.service;

import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.exceptions.ItemCategoryNameDoesntExists;
import com.kts.Restaurant.exceptions.ItemWithNameAlreadyExistsException;
import com.kts.Restaurant.exceptions.ItemWithNameDoesntExists;
import com.kts.Restaurant.model.DrinkItem;
import com.kts.Restaurant.model.FoodItem;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.ItemCategory;
import com.kts.Restaurant.repository.ItemCategoryRepository;
import com.kts.Restaurant.repository.ItemRepository;
import org.junit.Test;
//import org.junit.jupiter.api.Test.;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static com.kts.Restaurant.constants.ItemConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemServiceUnitTests {

    @Autowired
    ItemService itemService;

    @MockBean
    ItemRepository itemRepository;

    @MockBean
    ItemCategoryRepository itemCategoryRepository;

    
    ItemCategory itemCategory = new ItemCategory(DB_ITEM_CATEGORY_TYPE, DB_ITEM_CATEGORY_NAME, DB_ITEM_CATEGORY_ICON);

  

    @Test(expected =  ItemCategoryNameDoesntExists.class)
    public void create_item_with_non_existing_category_name() {
    	ItemDTO itemDto = new ItemDTO(DB_ITEM_NAME, DB_ITEM_DESCRIPTION, DB_ITEM_PRICE, DB_ITEM_COST, DB_ITEM_CATEGORY_NAME);
    	
        when(itemCategoryRepository.findItemCategoryByCategoryName(DB_ITEM_CATEGORY_NAME)).thenReturn(null);
        
        itemService.create(itemDto);
    }

    @Test(expected = ItemWithNameAlreadyExistsException.class)
    public void Create_item_with_Taken_existing_name(){
        Item newItem = new DrinkItem();
        ItemDTO itemDto = new ItemDTO(DB_ITEM_NAME, DB_ITEM_DESCRIPTION, DB_ITEM_PRICE, DB_ITEM_COST, DB_ITEM_CATEGORY_NAME);
        when(itemCategoryRepository.findItemCategoryByCategoryName(DB_ITEM_CATEGORY_NAME)).thenReturn(new ItemCategory());
        when(itemRepository.findByName(DB_ITEM_NAME)).thenReturn(newItem);
        itemService.create(itemDto);
    }

    @Test
    public void Create_food_item_success(){
        ItemDTO itemDto = new ItemDTO("newItem", "newDescription", 300, 100, "catName", "path", "alergens", "45min");
        ItemCategory cat = new ItemCategory();
        cat.setType("Food");
        Item newItem = new DrinkItem("newItem", 300, 100);
        when(itemCategoryRepository.findItemCategoryByCategoryName("catName")).thenReturn(cat);
        when(itemRepository.findByName("newItem")).thenReturn(null);
        when(itemRepository.save(newItem)).thenReturn(newItem);
        ItemDTO returnedDTO = itemService.create(itemDto);
        assertEquals(returnedDTO.getName(), itemDto.getName());
    }
    
    @Test(expected = ItemWithNameDoesntExists.class)
    public void Update_item_with_name_not_existing(){
        String oldName = "oldName";
        ItemDTO itemDto = new ItemDTO(DB_ITEM_NAME, DB_ITEM_DESCRIPTION, DB_ITEM_PRICE, DB_ITEM_COST, DB_ITEM_CATEGORY_NAME);
        when(itemCategoryRepository.findItemCategoryByCategoryName(DB_ITEM_CATEGORY_NAME)).thenReturn(new ItemCategory());
        when(itemRepository.findByName(oldName)).thenReturn(null);
        itemService.update(oldName,itemDto);
    }
    
    @Test
    public void Update_food_item_success(){
    	String oldName = "oldName";
        ItemDTO itemDto = new ItemDTO("newItem", "newDescription", 300, 100, "catName", "path", "alergens", "45min");
        ItemCategory cat = new ItemCategory();
        cat.setType("Food");
        Item newItem = new DrinkItem("newItem", 300, 100);
        when(itemCategoryRepository.findItemCategoryByCategoryName("catName")).thenReturn(cat);
        when(itemCategoryRepository.findItemCategoryByCategoryName(null)).thenReturn(new ItemCategory());
        when(itemRepository.findByName("oldName")).thenReturn(new FoodItem());
        when(itemRepository.save(newItem)).thenReturn(newItem);
//        when(itemService.create(itemDto)).thenReturn()
        ItemDTO returnedDTO = itemService.update(oldName,itemDto);
        assertEquals(returnedDTO.getName(), itemDto.getName());
    }



}

