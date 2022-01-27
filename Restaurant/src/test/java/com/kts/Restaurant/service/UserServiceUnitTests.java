package com.kts.Restaurant.service;

import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.exceptions.UserWIthUsernameNotFound;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import com.kts.Restaurant.model.Role;
import com.kts.Restaurant.model.Salary;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.RoleRepository;
import com.kts.Restaurant.repository.UserRepository;
import com.kts.Restaurant.util.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.kts.Restaurant.constants.UserConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UserServiceUnitTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository mockedUserRepository;

    @MockBean
    private RoleRepository mockedRoleRepository;


//    User existingUser = new User(DB_USER_FIRSTNAME, DB_USER_LASTNAME, DB_USER_USERNAME, new Role(DB_USER_ROLE), DB_USER_PASSWORD, DB_USER_PIN, new ArrayList<>(), true);
//
//
//    @Test
//    public void Create_user_success() throws Exception {
//        when(mockedRoleRepository.findByRole(DB_NEW_USER_ROLE)).thenReturn(new Role(5L, DB_NEW_USER_ROLE));
//
//        UserDTO userDTO = new UserDTO(DB_NEW_USER_FIRSTNAME, DB_NEW_USER_LASTNAME, DB_NEW_USER_USERNAME, DB_NEW_USER_PASSWORD, DB_NEW_USER_ROLE, DB_NEW_USER_PIN, DB_NEW_USER_SALARYAMOUNT, true);
//        UserDTO created = userService.create(userDTO);
//        assertNotNull(created);
//        assertEquals(userDTO.getUsername(), created.getUsername());
//    }
//
//    @Test(expected = UserWithUsernameAlreadyExistsException.class)
//    public void Create_user_with_existing_username() throws Exception {
//        when(mockedRoleRepository.findByRole(DB_USER_ROLE)).thenReturn(new Role(10L, DB_USER_ROLE));
//        when(mockedUserRepository.findByUsername(DB_USER_USERNAME)).thenReturn(existingUser);
//        UserDTO userDTO = new UserDTO(DB_NEW_USER_FIRSTNAME, DB_NEW_USER_LASTNAME, DB_USER_USERNAME, DB_NEW_USER_PASSWORD, DB_NEW_USER_ROLE, DB_NEW_USER_PIN, DB_NEW_USER_SALARYAMOUNT, true);
//        UserDTO created = userService.create(userDTO);
//    }
//
//
//    @Test(expected = UserWIthUsernameNotFound.class)
//    public void Update_user_with_non_existing_username() throws Exception {
//        when(mockedRoleRepository.findByRole(DB_USER_ROLE)).thenReturn(new Role(10L, DB_USER_ROLE));
//        when(mockedUserRepository.findByUsername(DB_NEW_USER_USERNAME)).thenReturn(null);
//        UserDTO userDTO = new UserDTO(DB_NEW_USER_FIRSTNAME, DB_NEW_USER_LASTNAME, DB_USER_USERNAME, DB_NEW_USER_PASSWORD, DB_NEW_USER_ROLE, DB_NEW_USER_PIN, DB_NEW_USER_SALARYAMOUNT, true);
//        UserDTO created = userService.update(userDTO);
//    }
//
//
//    @Test
//    public void Update_user_new_role() throws Exception {
//        when(mockedRoleRepository.findByRole(DB_USER_ROLE)).thenReturn(new Role(10L, DB_USER_ROLE));
//        when(mockedRoleRepository.findByRole("COOK")).thenReturn(new Role(10L, "COOK"));
//        when(mockedUserRepository.findByUsername(DB_USER_USERNAME)).thenReturn(existingUser);
//        UserDTO userDTO = new UserDTO(DB_USER_FIRSTNAME, DB_USER_LASTNAME, DB_USER_USERNAME, DB_USER_PASSWORD, "COOK", DB_USER_PIN, 1300, true);
//        UserDTO updated = userService.update(userDTO);
//        String role = updated.getRole();
//        assertEquals("COOK", role);
//    }
//
//
//    @Test(expected = UserWIthUsernameNotFound.class)
//    public void Delete_user_with_non_existing_username() throws Exception {
//        when(mockedRoleRepository.findByRole(DB_USER_ROLE)).thenReturn(new Role(10L, DB_USER_ROLE));
//        when(mockedUserRepository.findByUsername(DB_USER_USERNAME)).thenReturn(null);
//        String username = DB_USER_USERNAME;
//        UserDTO created = userService.logicalDelete(username);
//    }
//
//    @Test
//    public void Delete_user_success() throws Exception {
//        when(mockedRoleRepository.findByRole(DB_USER_ROLE)).thenReturn(new Role(10L, DB_USER_ROLE));
//        when(mockedUserRepository.findByUsername(DB_USER_USERNAME)).thenReturn(existingUser);
//        String username = DB_USER_USERNAME;
//        UserDTO created = userService.logicalDelete(username);
//        assertEquals(false, created.isActive());
//    }
//
//
//    @Test
//    public void Get_all(){
//        List<User> lista = new ArrayList<>();
//        lista.add(existingUser);
//        when(mockedUserRepository.findAll()).thenReturn(lista);
//        List<UserDTO> dtos = new ArrayList<>();
//
//        dtos = userService.getAll();
//        assertEquals(1, dtos.size());
//        UserMapper um = new UserMapper();
//        UserDTO all = um.toDto(existingUser);
//        assertEquals(all.getUsername(), lista.get(0).getUsername());
//    }
//
//    @Test
//    public void Get_all_by_role(){
//        when(mockedRoleRepository.findByRole("MANAGER")).thenReturn(new Role(10L, "MANAGER"));
//        List<User> users = new ArrayList();
//        users.add(existingUser);
//        when(mockedUserRepository.findAllByRole("MANAGER")).thenReturn(users);
//        List<UserDTO> dtos = new ArrayList<>();
//        UserMapper um = new UserMapper();
//        dtos.add(um.toDto(users.get(0)));
//
//        List<UserDTO> returnList = userService.getAllByRole("MANAGER");
//        assertEquals(dtos.size(), users.size());
//
//    }


}
