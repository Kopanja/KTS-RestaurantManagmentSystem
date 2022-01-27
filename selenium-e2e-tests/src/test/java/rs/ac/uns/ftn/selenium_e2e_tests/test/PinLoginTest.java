package rs.ac.uns.ftn.selenium_e2e_tests.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import rs.ac.uns.ftn.selenium_e2e_tests.pages.BartenderPage;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.HomePage;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.PinPage;

public class PinLoginTest {
	
	private WebDriver browser;
	HomePage homePage;
	PinPage pinLoginPage;
	BartenderPage bartenderPage;
	
	@Before
	public void setupSelenium() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("http://localhost:4200/");

		browser.manage().deleteAllCookies();


		homePage = PageFactory.initElements(browser, HomePage.class);
		pinLoginPage = PageFactory.initElements(browser, PinPage.class);
		bartenderPage = PageFactory.initElements(browser, BartenderPage.class);

	}
	
	@Test
	public void usernamePasswordLoginTest() throws InterruptedException{
		
		homePage.pinButtonClick();
		assertEquals("http://localhost:4200/pin-login", browser.getCurrentUrl());
		pinLoginPage.writePinInput("2222");
		pinLoginPage.logInButtonClick();
		//Thread.sleep(2000);
		bartenderPage.ensureOrdersAreDisplayed();
		assertEquals("http://localhost:4200/bartender", browser.getCurrentUrl());
		
		
	}
	
	
	
	@After
	public void closeSelenium() {
		browser.quit();
	}

}
