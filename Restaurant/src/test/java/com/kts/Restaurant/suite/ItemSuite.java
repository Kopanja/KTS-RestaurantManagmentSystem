package com.kts.Restaurant.suite;

import com.kts.Restaurant.controller.ItemControllerIntegrationTests;
import com.kts.Restaurant.repository.DBTestRepository;
import com.kts.Restaurant.repository.ItemRepositoryTest;
import com.kts.Restaurant.service.ItemService;
import com.kts.Restaurant.service.ItemServiceUnitTests;
import com.kts.Restaurant.service.PinCredentialsServiceIntegrationTests;
import com.kts.Restaurant.service.PinCredentialsServiceUnitTests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ItemServiceUnitTests.class,
        ItemRepositoryTest.class,
        ItemControllerIntegrationTests.class

})
public class ItemSuite {

	

   
	
}
