package rs.ac.uns.ftn.selenium_e2e_tests.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import rs.ac.uns.ftn.selenium_e2e_tests.test.PlaceOrderTest;
@RunWith(Suite.class)
@SuiteClasses({
	PlaceOrderTest.class,

})
public class SuiteAll {

}
