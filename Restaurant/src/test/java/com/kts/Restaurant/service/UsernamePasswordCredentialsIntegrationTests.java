package com.kts.Restaurant.service;

import com.kts.Restaurant.model.UsernamePasswordCredentials;
import com.kts.Restaurant.repository.UsernamePasswordCredentialsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class UsernamePasswordCredentialsIntegrationTests {


    @Autowired
    UsernamePasswordCredentialsService usernamePasswordCredentialsService;

    @Autowired
    UsernamePasswordCredentialsRepository usernamePasswordCredentialsRepository;

    public static final String username = "menager@gmail.com";
    public static final String newUsername = "NovUsernameTest@test.com";
    public static final String newPassword = "6545235";

    @Test
    public void Find_by_username_success(){
        UsernamePasswordCredentials usn = usernamePasswordCredentialsService.findByUsername(username);
        assertNotNull(usn);
    }

    @Test
    public void Find_by_username_with_bad_username(){
        UsernamePasswordCredentials usn = usernamePasswordCredentialsService.findByUsername("nekiUsername");
        assertNull(usn);
    }

    @Test
    public void Create_success(){
        String noviUsername = newUsername;
        String password = newPassword;
        UsernamePasswordCredentials creds = usernamePasswordCredentialsService.create(noviUsername, password);
        assertNotNull(creds);
    }


    @Test
    public void Delete_success(){
        UsernamePasswordCredentials um = usernamePasswordCredentialsService.findByUsername(newUsername);
        int numberOfUsns = usernamePasswordCredentialsRepository.findAll().size();
        if (um != null) {
            usernamePasswordCredentialsService.delete(um);
            assertEquals(numberOfUsns - 1, usernamePasswordCredentialsRepository.findAll().size());

        } else {
            assertEquals(numberOfUsns , usernamePasswordCredentialsRepository.findAll().size());
        }
    }


}
