package com.kts.Restaurant.service;

import com.kts.Restaurant.model.PinCredentials;
import com.kts.Restaurant.repository.PinCredentialsRepository;
import com.kts.Restaurant.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class PinCredentialsServiceUnitTests {

    @Autowired
    PinCredentialsService pinCredentialsService;

    @MockBean
    PinCredentialsRepository pinCredentialsRepository;

    @MockBean
    UserRepository userRepository;

    public static final String pinSuccess = "53532434";
    PinCredentials onlyOne = new PinCredentials("1");


    @Test
    public void Find_by_user_id_success() {
        Mockito.when(pinCredentialsRepository.findByUserId(1L)).thenReturn(onlyOne);
        PinCredentials newOne = pinCredentialsService.findByUserId(1L);
        assertNotNull(newOne);
    }


}
