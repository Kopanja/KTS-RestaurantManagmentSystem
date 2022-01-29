package com.kts.Restaurant.controller;


import com.kts.Restaurant.dto.AuthenticationResponseDTO;
import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.dto.OrderDTO;
import com.kts.Restaurant.dto.UsernamePasswordCredentialsDTO;
import com.kts.Restaurant.service.CookService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class CookControllerIntegrationTests {


    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    CookService cookService;

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


//    public void Get_orders_for_cook(){
//        ResponseEntity<OrderDTO[]> responseEntity;
//
//        responseEntity = restTemplate.exchange("/api/cook",
//                HttpMethod.GET, new HttpEntity<Object>(headers), OrderDTO[].class);
//        OrderDTO[] orders = responseEntity.getBody();
//        Assertions.assertNotNull(orders);
//        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//    }
}
