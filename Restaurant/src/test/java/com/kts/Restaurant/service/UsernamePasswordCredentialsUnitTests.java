package com.kts.Restaurant.service;

import com.kts.Restaurant.model.UsernamePasswordCredentials;
import com.kts.Restaurant.repository.UsernamePasswordCredentialsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UsernamePasswordCredentialsUnitTests {

    @Autowired
    UsernamePasswordCredentialsService usernamePasswordCredentialsService;

    @MockBean
    UsernamePasswordCredentialsRepository usernamePasswordCredentialsRepository;

    public static final String usernameSuccess = "marko@gmail.com";
    public static final String passwordSuccess = "sifra123";
    public static final String badUsername = "bad@gmail.com";
    UsernamePasswordCredentials upcSuccess = new UsernamePasswordCredentials(usernameSuccess, passwordSuccess);

    @Test
    public void Find_by_username_success(){

        Mockito.when(usernamePasswordCredentialsRepository.findByUsername(usernameSuccess)).thenReturn(upcSuccess);
        UsernamePasswordCredentials newOne = usernamePasswordCredentialsService.findByUsername(usernameSuccess);
        assertNotNull(newOne);
        assertEquals(usernameSuccess, newOne.getUsername());
        assertEquals(passwordSuccess, newOne.getPassword());
    }

    @Test
    public void Find_by_username_with_non_existing_username() {
        Mockito.when(usernamePasswordCredentialsRepository.findByUsername(badUsername)).thenReturn(null);
        UsernamePasswordCredentials um = usernamePasswordCredentialsService.findByUsername(badUsername);
        assertNull(um);
    }


    @Test
    public void Create_success() {
        Mockito.when(usernamePasswordCredentialsRepository.save(upcSuccess)).thenReturn(upcSuccess);
        UsernamePasswordCredentials newOne = usernamePasswordCredentialsService.create(usernameSuccess, passwordSuccess);
        if (newOne != null) {
            assertNotNull(newOne);
            assertEquals(usernameSuccess, newOne.getUsername());
            assertEquals(passwordSuccess, newOne.getPassword());
        } else {
            assertNull(newOne);
        }
    }
}
