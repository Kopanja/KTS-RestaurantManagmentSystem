package rs.ac.uns.ftn.selenium_e2e_tests.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import rs.ac.uns.ftn.selenium_e2e_tests.pages.BartenderPage;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.CookPage;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.FloorLayoutComponent;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.MenuComponent;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.OrderComponent;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.PinPage;
import rs.ac.uns.ftn.selenium_e2e_tests.pages.TableComponent;

public class PlaceOrderTest {
	private WebDriver waiterBrowser;
	private WebDriver bartenderBrowser;
	private WebDriver cookBrowser;

	FloorLayoutComponent floorLayout;
	TableComponent tableComponent;
	OrderComponent orderComponent;
	MenuComponent menuComponent;
	BartenderPage bartenderPage;
	CookPage cookPage;
	PinPage pinLoginPageBartender;
	PinPage pinLoginPageWaiter;
	PinPage pinLoginPageCook;
	

	@Before
	public void setupSelenium() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		waiterBrowser = new ChromeDriver();
		waiterBrowser.manage().window().maximize();
		// browser.manage().window().setSize(new Dimension(960, 1080));
		// browser.manage().window().setPosition(new Point(0,0));
		waiterBrowser.navigate().to("http://localhost:4200/pin-login");

		waiterBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		waiterBrowser.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		waiterBrowser.manage().deleteAllCookies();

		bartenderBrowser = new ChromeDriver();
		// browser2.manage().window().maximize();
		bartenderBrowser.manage().window().setSize(new Dimension(960, 590));
		bartenderBrowser.manage().window().setPosition(new Point(960, 0));
		bartenderBrowser.navigate().to("http://localhost:4200/pin-login");

		bartenderBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		bartenderBrowser.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		bartenderBrowser.manage().deleteAllCookies();

		cookBrowser = new ChromeDriver();
		// browser2.manage().window().maximize();
		cookBrowser.manage().window().setSize(new Dimension(960, 590));
		cookBrowser.manage().window().setPosition(new Point(960, 590));
		cookBrowser.navigate().to("http://localhost:4200/pin-login");

		cookBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cookBrowser.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		cookBrowser.manage().deleteAllCookies();

		floorLayout = PageFactory.initElements(waiterBrowser, FloorLayoutComponent.class);
		tableComponent = PageFactory.initElements(waiterBrowser, TableComponent.class);
		orderComponent = PageFactory.initElements(waiterBrowser, OrderComponent.class);
		menuComponent = PageFactory.initElements(waiterBrowser, MenuComponent.class);
		pinLoginPageWaiter = PageFactory.initElements(waiterBrowser, PinPage.class);

		bartenderPage = PageFactory.initElements(bartenderBrowser, BartenderPage.class);
		pinLoginPageBartender = PageFactory.initElements(bartenderBrowser, PinPage.class);
		
		cookPage = PageFactory.initElements(cookBrowser, CookPage.class);
		pinLoginPageCook = PageFactory.initElements(cookBrowser, PinPage.class);

	}

	@Test
	public void placingOrderTest() throws InterruptedException {

		//Logins
		assertEquals("http://localhost:4200/pin-login", bartenderBrowser.getCurrentUrl());
		pinLoginPageBartender.writePinInput("2222");
		pinLoginPageBartender.logInButtonClick();
		//Thread.sleep(2000);
		bartenderPage.ensureTitleIsDisplayed();
		assertEquals("http://localhost:4200/bartender", bartenderBrowser.getCurrentUrl());
		
		
		
		
		pinLoginPageWaiter.writePinInput("1111");
		pinLoginPageWaiter.logInButtonClick();
		//Thread.sleep(2000);
		floorLayout.ensureTablesAreDisplayed();
		assertEquals("http://localhost:4200/waiter", waiterBrowser.getCurrentUrl());
		// select first floor for testing
		floorLayout.getFloor1().click();
		
		//Treba da se promeni sa COOK userom post
		pinLoginPageCook.writePinInput("3333");
		pinLoginPageCook.logInButtonClick();
		//Thread.sleep(2000);
		cookPage.ensureTitleIsDisplayed();
		assertEquals("http://localhost:4200/cook", cookBrowser.getCurrentUrl());
		
// -------------SELECTING TABLE TEST----------------------------
		String selectedTableCSSClass = "table-selected";
		String occupiedTableCSSClass = "occupied";
		String orderTitle = "Table: Table6";
		String tableName = "Table6";

		tableComponent.setTableName(tableName);
		tableComponent.ensureTableImageIsDisplayed();
		tableComponent.getTableImage().click();

		System.out.println(tableComponent.getTableImage().getAttribute("class"));
		// check if table is selected
		assertTrue(tableComponent.getTableImage().getAttribute("class").contains(selectedTableCSSClass));
		// check if order title has selected table name
		assertEquals(orderTitle, orderComponent.getOrderTitle().getText());
		// check if place order button is disabled
		assertFalse(orderComponent.getPlaceOrderButton().isEnabled());

// -----------ADDING ITEMS TO ORDER LIST TEST------------------------------
		menuComponent.ensureDrinkIsDisplayed();
		menuComponent.getDrink().click();
		
		menuComponent.ensureCoffeCatIsDisplayed();
		menuComponent.getCoffeCategory().click();
		
		menuComponent.ensureAmericanoIsDisplayed();
		menuComponent.getAmericanoItem().click();
		
		menuComponent.ensureCocktailCatIsDisplayed();
		menuComponent.getCocktailCategory().click();
		
		menuComponent.ensureMojitoIsDisplayed();
		menuComponent.getMojitoItem().click();
		
		menuComponent.ensureBackButtonIsDisplayed();
		menuComponent.getBackButton().click();
		
		menuComponent.ensureElementIsClickable(menuComponent.getFood());
		menuComponent.getFood().click();
		
		menuComponent.ensureElementIsClickable(menuComponent.getPizzaCategory());
		menuComponent.getPizzaCategory().click();
		
		menuComponent.ensureElementIsClickable(menuComponent.getMargaritaItem());
		menuComponent.getMargaritaItem().click();
		
		menuComponent.ensureElementIsClickable(menuComponent.getDessertCategory());
		menuComponent.getDessertCategory().click();
		
		menuComponent.ensureElementIsClickable(menuComponent.getTiramisuItem());
		menuComponent.getTiramisuItem().click();
		//menuComponent.getDrink().click();
		//menuComponent.getFood().click();
		//Thread.sleep(2000);

		// check if items were added to order list
		assertTrue(orderComponent.getPreOrderItemList().size() == 4);

		// check if last item in list is food, with price 1000
		assertEquals("Tiramisu", orderComponent.getLastItemName().getText());
		assertEquals("390", orderComponent.getLastItemPrice().getText());

		// check if total price is 1300
		assertEquals("Total Price: 1700", orderComponent.getTotalPrice().getText());

// -----------REMOVING LAST ITEM FROM ORDER LIST TEST------------------------------
		orderComponent.ensureItemRemovedButtonIsDisplayed();
		orderComponent.getLastItemRemoveButton().click();
		// Thread.sleep(500);
		// check if items were added to order list
		assertTrue(orderComponent.getPreOrderItemList().size() == 3);

		// check if total price is 1300
		assertEquals("Total Price: 1310", orderComponent.getTotalPrice().getText());

//-----------PLACE ORDER TEST---------------------------------------
		// check if place order is now enabled
		assertTrue(orderComponent.getPlaceOrderButton().isEnabled());
		orderComponent.getPlaceOrderButton().click();
		// wait for css class to be active
		bartenderPage.ensureOrdersAreDisplayed();
		cookPage.ensureOrdersAreDisplayed();
		// check if table is occupied
		assertTrue(tableComponent.getTableImage().getAttribute("class").contains(occupiedTableCSSClass));
		// check if ordered items are placed
		assertTrue(orderComponent.getLastItemName().getAttribute("class").contains("text-not-prepared"));
		assertTrue(orderComponent.getLastItemPrice().getAttribute("class").contains("text-not-prepared"));
		// check if ordered appeared on the bartender page
		assertTrue(bartenderPage.getOrders().size() > 0);
		// check if there are two items in bartender order
		assertTrue(bartenderPage.getOrderedItems().size() == 2);

		// check if ordered appeared on the bartender page
		assertTrue(cookPage.getOrders().size() > 0);
		// check if there are two items in bartender order
		assertTrue(cookPage.getOrderedItems().size() == 1);
		// check if last item is Refreshing drink
		assertEquals("Margarita", cookPage.getLastItemName().getText());

	}

	@After
	public void closeSelenium() {
		waiterBrowser.quit();
		bartenderBrowser.quit();
		cookBrowser.quit();
	}

}
