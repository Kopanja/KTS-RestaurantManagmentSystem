package com.kts.Restaurant.service;


import com.kts.Restaurant.model.Role;
import com.kts.Restaurant.repository.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public class RoleServiceIntegrationTests {

    @Autowired
    RoleService roleService;

    @Autowired
    RoleRepository roleRepository;


    @Test
    public void Create_roles_success()  {
        roleService.createRoles();
    }


    @Test
    public void Get_all_roles_success()  {
        List<Role> roles =  roleService.getAll();
        assertEquals(5,roles.size());
    }

}
