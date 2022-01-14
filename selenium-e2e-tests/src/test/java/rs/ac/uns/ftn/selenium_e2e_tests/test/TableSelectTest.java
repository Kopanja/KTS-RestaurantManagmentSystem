package rs.ac.uns.ftn.selenium_e2e_tests.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import rs.ac.uns.ftn.selenium_e2e_tests.pages.FloorLayoutComponent;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.MenuComponent;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.OrderComponent;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.TableComponent;

public class TableSelectTest {
	private WebDriver browser;

	FloorLayoutComponent floorLayout;
	TableComponent tableComponent;
	OrderComponent orderComponent;
	MenuComponent menuComponent;

	@Before
	public void setupSelenium() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("http://localhost:4200/floor-layout");

		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		browser.manage().deleteAllCookies();

		floorLayout = PageFactory.initElements(browser, FloorLayoutComponent.class);
		tableComponent = PageFactory.initElements(browser, TableComponent.class);
		orderComponent = PageFactory.initElements(browser, OrderComponent.class);
		menuComponent = PageFactory.initElements(browser, MenuComponent.class);
	}

	@Test
	public void placingOrderTest() throws InterruptedException {

		// check if we are on the waiter page
		assertEquals("http://localhost:4200/floor-layout", browser.getCurrentUrl());

		// select first floor for testing
		floorLayout.getFloor1().click();

// -------------SELECTING TABLE TEST----------------------------
		String selectedTableCSSClass = "table-selected";
		String occupiedTableCSSClass = "occupied";
		String orderTitle = "Table: Table1";
		String tableName = "Table1";

		tableComponent.setTableName(tableName);
		tableComponent.ensureTableImageIsDisplayed();
		tableComponent.getTableImage().click();

		// check if table is selected
		assertTrue(tableComponent.getTableImage().getAttribute("class").contains(selectedTableCSSClass));
		// check if order title has selected table name
		assertEquals(orderTitle, orderComponent.getOrderTitle().getText());
		// check if place order button is disabled
		assertFalse(orderComponent.getPlaceOrderButton().isEnabled());

// -----------ADDING ITEMS TO ORDER LIST TEST------------------------------
		menuComponent.ensureDrinkIsDisplayed();
		menuComponent.ensureFoodIsDisplayed();
		menuComponent.getFood().click();
		//Thread.sleep(500);
		menuComponent.getDrink().click();
		//Thread.sleep(500);
		menuComponent.getDrink().click();
		//Thread.sleep(500);
		menuComponent.getFood().click();
		//Thread.sleep(500);

		// check if items were added to order list
		assertTrue(orderComponent.getPreOrderItemList().size() == 4);

		// check if last item in list is food, with price 1000
		assertEquals("Delicious food", orderComponent.getLastItemName().getText());
		assertEquals("1000", orderComponent.getLastItemPrice().getText());

		// check if total price is 1300
		assertEquals("Total Price: 2300", orderComponent.getTotalPrice().getText());

// -----------REMOVING LAST ITEM FROM ORDER LIST TEST------------------------------
		orderComponent.ensureItemRemovedButtonIsDisplayed();
		orderComponent.getLastItemRemoveButton().click();
		//Thread.sleep(500);
		// check if items were added to order list
		assertTrue(orderComponent.getPreOrderItemList().size() == 3);

		// check if total price is 1300
		assertEquals("Total Price: 1300", orderComponent.getTotalPrice().getText());

//-----------PLACE ORDER TEST---------------------------------------
		// check if place order is now enabled
		assertTrue(orderComponent.getPlaceOrderButton().isEnabled());
		orderComponent.getPlaceOrderButton().click();
		//wait for css class to be active
		Thread.sleep(3000);
		//check if table is occupied
		assertTrue(tableComponent.getTableImage().getAttribute("class").contains(occupiedTableCSSClass));
		//check if ordered items are placed
		assertTrue(orderComponent.getLastItemName().getAttribute("class").contains("text-not-prepared"));
		assertTrue(orderComponent.getLastItemPrice().getAttribute("class").contains("text-not-prepared"));
		//String selectedTableOrderPlacesCSSClass = "occupied table-selected";
		
	}

	@After
	public void closeSelenium() {
		browser.quit();
	}

}
