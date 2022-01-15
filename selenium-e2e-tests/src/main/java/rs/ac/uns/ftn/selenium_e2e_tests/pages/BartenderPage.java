package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BartenderPage {
	private WebDriver driver;
	
	@FindBy(tagName = "app-order-card")
	private List<WebElement> orders;
	
	@FindBy(xpath = "//*[contains(@class, 'item-wrapper')]")
	private List<WebElement> orderedItems;
	
	@FindBy(xpath = "//*[contains(@class, 'item-wrapper')][last()]/div[1]")
	private WebElement lastItemName;
	
	public BartenderPage (WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getOrders() {
		return orders;
	}

	public void setOrders(List<WebElement> orders) {
		this.orders = orders;
	}

	public List<WebElement> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<WebElement> orderedItems) {
		this.orderedItems = orderedItems;
	}

	public WebElement getLastItemName() {
		return lastItemName;
	}

	public void setLastItemName(WebElement lastItemName) {
		this.lastItemName = lastItemName;
	}
	
	
	

}
