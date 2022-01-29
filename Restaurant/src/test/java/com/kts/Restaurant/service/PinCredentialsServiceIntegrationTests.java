package com.kts.Restaurant.service;

import com.kts.Restaurant.model.PinCredentials;
import com.kts.Restaurant.repository.PinCredentialsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import org.junit.Before;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class PinCredentialsServiceIntegrationTests {

    @Autowired
    PinCredentialsService pinCredentialsService;

    @Autowired
    PinCredentialsRepository pinCredentialsRepository;


    public static final Long userId = 118L;
//    public PinCredentials creds = null;

    
    @Test
    public void Create_pin_credentials() {
        PinCredentials creds = pinCredentialsService.create("195435");
        assertNotNull(creds);
    }

    @Test
    public void Delete_pin_credentials_success() {
        PinCredentials toDelete = pinCredentialsRepository.findByPin("195435");
        int numberOfPins = pinCredentialsRepository.findAll().size();
        if (toDelete != null) {
            pinCredentialsService.delete(toDelete);
        }
        assertEquals( numberOfPins - 1, pinCredentialsRepository.findAll().size());

    }

    @Test
    public void Delete_pin_credentials_non_existing_pin() {
        PinCredentials toDelete = pinCredentialsRepository.findByPin("-500");
        int numberOfPins = pinCredentialsRepository.findAll().size();
        if (toDelete != null) {
            pinCredentialsService.delete(toDelete);
            assertEquals( numberOfPins - 1, pinCredentialsRepository.findAll().size());

        }else{
            assertEquals( numberOfPins , pinCredentialsRepository.findAll().size());
        }
    }


//    @Test
//    public void Find_by_user_id_success(){
//        PinCredentials pin = pinCredentialsService.findByUserId(131L);
//        assertNotNull(pin);
//    }

    @Test
    public void Find_by_user_id_bad_id(){
        PinCredentials pin = pinCredentialsService.findByUserId(543543645L);
        assertNull(pin);
    }



}
