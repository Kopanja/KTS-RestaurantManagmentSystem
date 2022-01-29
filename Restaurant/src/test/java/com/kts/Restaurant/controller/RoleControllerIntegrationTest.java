package com.kts.Restaurant.controller;

import com.kts.Restaurant.dto.AuthenticationResponseDTO;
import com.kts.Restaurant.dto.UsernamePasswordCredentialsDTO;
import com.kts.Restaurant.model.Role;
import com.kts.Restaurant.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class RoleControllerIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    RoleService roleService;

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
    public void Get_all_roles() {

        ResponseEntity<Role[]> responseEntity;

        responseEntity = restTemplate.exchange("/api/role/getAll",
                HttpMethod.GET, new HttpEntity<Object>(headers), Role[].class);
        Role[] roles = responseEntity.getBody();
        Assertions.assertNotNull(roles);
        Assertions.assertEquals(5, roles.length);

    }
}


//    @Before
//    public void login() {
//        ResponseEntity<String> login =
//                restTemplate.postForEntity("localhost:8080/api/auth/pin-login",
//                        new PinCredentials("1111"),
//                        String.class);
//        accessToken = login.getBody();
//        headers.add("Authorization", "Bearer "+accessToken);
//    }