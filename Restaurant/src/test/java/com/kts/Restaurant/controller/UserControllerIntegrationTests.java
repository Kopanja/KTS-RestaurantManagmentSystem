package com.kts.Restaurant.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kts.Restaurant.dto.AuthenticationResponseDTO;
import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.dto.UsernamePasswordCredentialsDTO;
import com.kts.Restaurant.exceptions.UserWIthUsernameNotFound;
import com.kts.Restaurant.model.Credentials;
import com.kts.Restaurant.model.Role;
import com.kts.Restaurant.model.UsernamePasswordCredentials;
import com.kts.Restaurant.repository.UserRepository;
import com.kts.Restaurant.service.RoleService;
import com.kts.Restaurant.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UserControllerIntegrationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

//    @MockBean
//    UserRepository userRepository;
//
    private String accessToken;
    private HttpHeaders headers = new HttpHeaders();

    @Before
    public void login() {
        ResponseEntity<AuthenticationResponseDTO> login =
                restTemplate.postForEntity("/api/auth/usrn-pass-login",
                        new UsernamePasswordCredentialsDTO("admin@gmail.com", "admin"),
                        AuthenticationResponseDTO.class);
        accessToken = login.getBody().getJwt();
        System.out.println(accessToken);
        headers.add("Authorization", "Bearer " + accessToken);
    }

    @Test
    public void Update_success(){
//        Credentials creds = new UsernamePasswordCredentials("markoS@gmail.com", "sifrica1");
        UserDTO newUser = new UserDTO();
        newUser.setId(131L);
        newUser.setFirstname("Nikola");
        newUser.setLastname("Suhanov");
        newUser.setActive(true);
        newUser.setRole("MANAGER");
        newUser.setSalaryAmount(125400);
//        newUser.setCredentials(creds);

        ResponseEntity<UserDTO> responseEntity;

        responseEntity = restTemplate.exchange("/api/user/update",
                HttpMethod.PUT, new HttpEntity<Object>( newUser, headers), UserDTO.class);
        UserDTO created = responseEntity.getBody();
        Assertions.assertNotNull(created);
        Assertions.assertEquals( "Nikola", created.getFirstname());

    }

    @Test
    public void Update_bad_request(){
//        Credentials creds = new UsernamePasswordCredentials("markoS@gmail.com", "sifrica1");
//        Mockito.when(userRepository.findById(-5L)).thenReturn(null);
        UserDTO newUser = new UserDTO();
        newUser.setId(-5L);
        newUser.setFirstname("Nikola");
        newUser.setLastname("Suhanov");
        newUser.setActive(true);
        newUser.setRole("MANAGER");
        newUser.setSalaryAmount(125400);
//        newUser.setCredentials(creds);

        ResponseEntity<UserDTO> responseEntity;

        responseEntity = restTemplate.exchange("/api/user/update",
                HttpMethod.PUT, new HttpEntity<Object>( newUser, headers), UserDTO.class);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
//        UserDTO created = responseEntity.getBody();
//        Assertions.assertNotNull(created);
//        Assertions.assertEquals( "Nikola", created.getFirstname());

    }

}
