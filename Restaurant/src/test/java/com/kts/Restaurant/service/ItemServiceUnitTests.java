package com.kts.Restaurant.service;

import com.kts.Restaurant.constants.ItemConstants;
import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.exceptions.ItemCategoryNameDoesntExists;
import com.kts.Restaurant.exceptions.ItemWithNameAlreadyExistsException;
import com.kts.Restaurant.model.DrinkItem;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.ItemCategory;
import com.kts.Restaurant.repository.ItemCategoryRepository;
import com.kts.Restaurant.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import static com.kts.Restaurant.constants.ItemConstants.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ItemServiceUnitTests {

    @Autowired
    ItemService itemService;

    @MockBean
    ItemRepository itemRepository;

    @MockBean
    ItemCategoryRepository itemCategoryRepository;

    ItemDTO itemDto = new ItemDTO(DB_ITEM_NAME, DB_ITEM_PRICE, DB_ITEM_COST, DB_ITEM_DESCRIPTION);
    ItemCategory itemCategory = new ItemCategory(DB_ITEM_CATEGORY_TYPE, DB_ITEM_CATEGORY_NAME, DB_ITEM_CATEGORY_ICON);

    @Before
    public void setup(){
        ItemDTO itemDto = new ItemDTO(DB_ITEM_NAME, DB_ITEM_PRICE, DB_ITEM_COST);
    }

    @Test(expected = ItemCategoryNameDoesntExists.class)
    public void Create_item_with_non_existing_category_name() throws Exception {

        when(itemCategoryRepository.findItemCategoryByCategoryName(DB_NEW_ITEM_CATEGORY_NAME)).thenReturn(itemCategory);;
        ItemDTO newItemDto = itemService.create(itemDto);
    }

    @Test(expected = ItemWithNameAlreadyExistsException.class)
    public void Create_item_with_non_existing_name(){
        Item newItem = new DrinkItem();
        when(itemRepository.findByName(DB_NEW_ITEM_NAME)).thenReturn(newItem);
    }

    @Test
    public void Create_food_item_success(){
        Item newItem = new DrinkItem(DB_DRINK_ITEM_NAME, DB_DRINK_ITEM_PRICE, DB_DRINK_ITEM_COST);
        when(itemService.create(itemDto));
    }



}

//  @Test(expected = UserWithUsernameAlreadyExistsException.class)
//    public void Create_user_with_existing_username() throws Exception {
//        when(mockedRoleRepository.findByRole(DB_USER_ROLE)).thenReturn(new Role(10L, DB_USER_ROLE));
//        when(mockedUserRepository.findByUsername(DB_USER_USERNAME)).thenReturn(existingUser);
//        UserDTO userDTO = new UserDTO(DB_NEW_USER_FIRSTNAME, DB_NEW_USER_LASTNAME, DB_USER_USERNAME, DB_NEW_USER_PASSWORD, DB_NEW_USER_ROLE, DB_NEW_USER_PIN, DB_NEW_USER_SALARYAMOUNT, true);
//        UserDTO created = userService.create(userDTO);
//    }