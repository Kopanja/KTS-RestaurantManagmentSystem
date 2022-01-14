package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderComponent {
	
	private WebDriver driver;
	
	@FindBy(id = "order-title")
	private WebElement orderTitle;
	
	@FindBy(id = "place-order-button")
	private WebElement placeOrderButton;
	
	@FindBy(id = "bill-order-button")
	private WebElement billOrderButton;
	
	@FindBy(id = "price-total")
	private WebElement totalPrice;
	
	@FindBy(className = "order-item-container")
	private List<WebElement> preOrderItemList;
	
	//*[contains(@class, 'order-item-container')][last()]/p[last()]
	@FindBy(xpath = "//*[contains(@class, 'order-item-container')][last()]/p[2]")
	private WebElement lastItemName;
	
	@FindBy(xpath = "//*[contains(@class, 'order-item-container')][last()]/p[3]")
	private WebElement lastItemPrice;
	
	@FindBy(xpath = "//*[contains(@class, 'order-item-container')][last()]/img")
	private WebElement lastItemRemoveButton;
	
	public OrderComponent (WebDriver driver) {
		this.driver = driver;
		
	}

	public void ensureItemRemovedButtonIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.lastItemRemoveButton));
	}

	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getOrderTitle() {
		return orderTitle;
	}


	public void setOrderTitle(WebElement orderTitle) {
		this.orderTitle = orderTitle;
	}


	public WebElement getPlaceOrderButton() {
		return placeOrderButton;
	}


	public void setPlaceOrderButton(WebElement placeOrderButton) {
		this.placeOrderButton = placeOrderButton;
	}


	public WebElement getBillOrderButton() {
		return billOrderButton;
	}


	public void setBillOrderButton(WebElement billOrderButton) {
		this.billOrderButton = billOrderButton;
	}


	public List<WebElement> getPreOrderItemList() {
		return preOrderItemList;
	}


	public void setPreOrderItemList(List<WebElement> preOrderItemList) {
		this.preOrderItemList = preOrderItemList;
	}


	public WebElement getLastItemName() {
		return lastItemName;
	}


	public void setLastItemName(WebElement lastItemName) {
		this.lastItemName = lastItemName;
	}


	public WebElement getLastItemPrice() {
		return lastItemPrice;
	}


	public void setLastItemPrice(WebElement lastItemPrice) {
		this.lastItemPrice = lastItemPrice;
	}


	public WebElement getLastItemRemoveButton() {
		return lastItemRemoveButton;
	}


	public void setLastItemRemoveButton(WebElement lastItemRemoveButton) {
		this.lastItemRemoveButton = lastItemRemoveButton;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(WebElement totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
	

}
