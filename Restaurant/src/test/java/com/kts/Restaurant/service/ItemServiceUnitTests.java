package com.kts.Restaurant.service;

import com.kts.Restaurant.exceptions.ItemCategoryNameDoesntExists;
import com.kts.Restaurant.repository.ItemCategoryRepository;
import com.kts.Restaurant.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

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


    @Test(expected = ItemCategoryNameDoesntExists.class)
    public void Create_item_with_non_existing_category_name() throws Exception {


    }
}

//  @Test(expected = UserWithUsernameAlreadyExistsException.class)
//    public void Create_user_with_existing_username() throws Exception {
//        when(mockedRoleRepository.findByRole(DB_USER_ROLE)).thenReturn(new Role(10L, DB_USER_ROLE));
//        when(mockedUserRepository.findByUsername(DB_USER_USERNAME)).thenReturn(existingUser);
//        UserDTO userDTO = new UserDTO(DB_NEW_USER_FIRSTNAME, DB_NEW_USER_LASTNAME, DB_USER_USERNAME, DB_NEW_USER_PASSWORD, DB_NEW_USER_ROLE, DB_NEW_USER_PIN, DB_NEW_USER_SALARYAMOUNT, true);
//        UserDTO created = userService.create(userDTO);
//    }