package rs.ac.uns.ftn.selenium_e2e_tests.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import rs.ac.uns.ftn.selenium_e2e_tests.pages.HomePage;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.MenagerPage;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.UserDetailsPage;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.UsernamePasswordLoginPage;

public class UserDetailsTest {

private WebDriver browser;
	
	HomePage homePage;
	UsernamePasswordLoginPage usernamePasswordLoginPage;
	UserDetailsPage userDetailsPage;
	
	
	@Before
	public void setupSelenium() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("http://localhost:4200/");

	//	browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//	browser.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		browser.manage().deleteAllCookies();


		homePage = PageFactory.initElements(browser, HomePage.class);
		usernamePasswordLoginPage = PageFactory.initElements(browser, UsernamePasswordLoginPage.class);
		userDetailsPage = PageFactory.initElements(browser, UserDetailsPage.class);

	}
	@Test
	public void usernamePasswordLoginTest() throws InterruptedException{
		
		homePage.usernamePassButtonClick();
		assertEquals("http://localhost:4200/usr-pass-login", browser.getCurrentUrl());
		usernamePasswordLoginPage.writeUserNameInput("menager@gmail.com");
		usernamePasswordLoginPage.writePasswordInput("menager");
		usernamePasswordLoginPage.logInButtonClick();
		//Thread.sleep(2000);
		assertEquals("http://localhost:4200/menager", browser.getCurrentUrl());
		
		
	}
	
	
	
	@After
	public void closeSelenium() {
		browser.quit();
	}
}
