package com.kts.Restaurant.controller;

import com.kts.Restaurant.dto.AuthenticationResponseDTO;
import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.dto.UsernamePasswordCredentialsDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Role;
import com.kts.Restaurant.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class ItemControllerIntegrationTests {

    @Autowired
    TestRestTemplate restTemplate;



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

    private static final String nonExistingName = "nekoTakoIme1";
    private static final String existingName = "Burger14";



    @Test
    public void Create_success(){
        ItemDTO dto = new ItemDTO();
        dto.setAlergens("pecurke");
        dto.setCost(50);
        dto.setPrice(100);
        dto.setDescription("opis1");
        dto.setItemCategoryName("Food");
        dto.setImgPath("putana1");
        dto.setName(nonExistingName);

        ResponseEntity<ItemDTO> responseEntity;

        responseEntity = restTemplate.exchange("/api/item/create",
                HttpMethod.POST, new HttpEntity<Object>( dto, headers), ItemDTO.class);
        ItemDTO created = responseEntity.getBody();
        Assertions.assertNotNull(created);
        Assertions.assertEquals( "Item1", created.getName());
    }

    @Test
    public void Create_when_item_category_name_doesnt_exists(){
        ItemDTO dto = new ItemDTO();
        dto.setAlergens("pecurke");
        dto.setCost(50);
        dto.setPrice(100);
        dto.setDescription("opis1");
        dto.setItemCategoryName("NEPOSTOJECE");
        dto.setImgPath("putana1");
        dto.setName(nonExistingName);

        ResponseEntity<ItemDTO> responseEntity;

        responseEntity = restTemplate.exchange("/api/item/create",
                HttpMethod.POST, new HttpEntity<Object>( dto, headers), ItemDTO.class);
        ItemDTO created = responseEntity.getBody();
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void Create_when_item_name_already_exists(){
        ItemDTO dto = new ItemDTO();
        dto.setAlergens("pecurke");
        dto.setCost(50);
        dto.setPrice(100);
        dto.setDescription("opis1");
        dto.setItemCategoryName("Food");
        dto.setImgPath("putana1");
        dto.setName(existingName);

        ResponseEntity<ItemDTO> responseEntity;

        responseEntity = restTemplate.exchange("/api/item/create",
                HttpMethod.POST, new HttpEntity<Object>( dto, headers), ItemDTO.class);
        ItemDTO created = responseEntity.getBody();
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }


    @Test
    public void Update_success(){
        ItemDTO dto = new ItemDTO();
        dto.setAlergens("pecurke");
        dto.setCost(50);
        dto.setPrice(100);
        dto.setDescription("opis1");
        dto.setItemCategoryName("Burger");
        dto.setImgPath("putana1");
        dto.setPrepTime("60");
        dto.setName("novoIme");
        System.out.println(dto);
        ResponseEntity<ItemDTO> responseEntity;

        responseEntity = restTemplate.exchange("/api/item/update/" + existingName,
                HttpMethod.PUT, new HttpEntity<Object>( dto, headers), ItemDTO.class);
        ItemDTO created = responseEntity.getBody();
        System.out.println(created);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(created);
        Assertions.assertEquals( "novoIme", created.getName());

    }

    @Test
    public void Update_when_item_category_doesnt_exists(){
        ItemDTO dto = new ItemDTO();
        dto.setAlergens("pecurke");
        dto.setCost(50);
        dto.setPrice(100);
        dto.setDescription("opis1");
        dto.setItemCategoryName("nepostojeca");
        dto.setImgPath("putana1");
        dto.setName("novoIme");

        ResponseEntity<ItemDTO> responseEntity;

        responseEntity = restTemplate.exchange("/api/item/update/" + existingName,
                HttpMethod.PUT, new HttpEntity<Object>( dto, headers), ItemDTO.class);
        ItemDTO created = responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        System.out.println(created);
//        Assertions.assertNotNull(created);
//        Assertions.assertEquals( "novoIme", created.getName());
    }

    @Test
    public void Update_when_item_name_doesnt_exists(){
        ItemDTO dto = new ItemDTO();
        dto.setAlergens("pecurke");
        dto.setCost(50);
        dto.setPrice(100);
        dto.setDescription("opis1");
        dto.setItemCategoryName("nepostojeca");
        dto.setImgPath("putana1");
        dto.setName("novoIme");

        ResponseEntity<ItemDTO> responseEntity;

        responseEntity = restTemplate.exchange("/api/item/update/" + "blablatruc",
                HttpMethod.PUT, new HttpEntity<Object>( dto, headers), ItemDTO.class);
        ItemDTO created = responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        System.out.println(created);
//        Assertions.assertNotNull(created);
//        Assertions.assertEquals( "novoIme", created.getName());
    }

    @Test
    public void Get_items(){
        ResponseEntity<ItemDTO[]> responseEntity;

        responseEntity = restTemplate.exchange("/api/item",
                HttpMethod.GET, new HttpEntity<Object>(headers), ItemDTO[].class);
        ItemDTO[] items = responseEntity.getBody();
        Assertions.assertNotNull(items);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        System.out.println(items.toString());

    }

    @Test
    public void Get_items_by_category_name_success(){
        ResponseEntity<ItemDTO[]> responseEntity;

        responseEntity = restTemplate.exchange("/api/item/Burger",
                HttpMethod.GET, new HttpEntity<Object>(headers), ItemDTO[].class);
        ItemDTO[] items = responseEntity.getBody();
        Assertions.assertNotNull(items);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }



}
