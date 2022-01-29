package com.kts.Restaurant.suite;

import com.kts.Restaurant.service.RoleServiceIntegrationTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RoleServiceIntegrationTests.class,

})
public class RoleSuite {
}
