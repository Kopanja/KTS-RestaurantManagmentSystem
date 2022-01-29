package com.kts.Restaurant.suite;

import com.kts.Restaurant.repository.OrderRepositoryTest;
import com.kts.Restaurant.service.ItemServiceUnitTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OrderRepositoryTest.class,


})
public class OrderSuite {
}
