package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuComponent {

	private WebDriver driver;
	
	@FindBy(id = "Delicious food")
	private WebElement food;
	
	@FindBy(id = "Refreshing drink")
	private WebElement drink;
	
	
	public MenuComponent (WebDriver driver) {
		this.driver = driver;
		
	}

	public void ensureFoodIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.food));
	}
	
	public void ensureDrinkIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.drink));
	}

	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getFood() {
		return food;
	}


	public void setFood(WebElement food) {
		this.food = food;
	}


	public WebElement getDrink() {
		return drink;
	}


	public void setDrink(WebElement drink) {
		this.drink = drink;
	}
	
	
}
