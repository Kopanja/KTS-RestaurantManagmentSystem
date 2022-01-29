package com.kts.Restaurant.suite;

import com.kts.Restaurant.repository.TableRepositoryTest;
import com.kts.Restaurant.service.RoleServiceIntegrationTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TableRepositoryTest.class,

})
public class TableSuite {
}
