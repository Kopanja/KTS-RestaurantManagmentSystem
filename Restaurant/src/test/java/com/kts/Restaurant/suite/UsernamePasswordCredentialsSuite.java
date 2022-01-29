package com.kts.Restaurant.suite;

import com.kts.Restaurant.model.UsernamePasswordCredentials;
import com.kts.Restaurant.service.PinCredentialsServiceIntegrationTests;
import com.kts.Restaurant.service.PinCredentialsServiceUnitTests;
import com.kts.Restaurant.service.UsernamePasswordCredentialsIntegrationTests;
import com.kts.Restaurant.service.UsernamePasswordCredentialsUnitTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UsernamePasswordCredentialsIntegrationTests.class,
        UsernamePasswordCredentialsUnitTests.class,

})
public class UsernamePasswordCredentialsSuite {
}
