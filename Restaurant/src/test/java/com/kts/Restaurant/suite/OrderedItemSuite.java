package com.kts.Restaurant.suite;

import com.kts.Restaurant.repository.OrderRepositoryTest;
import com.kts.Restaurant.repository.OrderedItemRepositoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OrderedItemRepositoryTest.class,


})
public class OrderedItemSuite {
}
