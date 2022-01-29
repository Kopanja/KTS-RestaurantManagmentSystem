package com.kts.Restaurant.suite;

import com.kts.Restaurant.service.PinCredentialsServiceIntegrationTests;
import com.kts.Restaurant.service.PinCredentialsServiceUnitTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PinCredentialsServiceIntegrationTests.class,
        PinCredentialsServiceUnitTests.class,

})
public class PinCredentialsSuite {
}
