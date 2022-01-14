package rs.ac.uns.ftn.selenium_e2e_tests.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableComponent {

	private WebDriver driver;
	
	private String tableName;
	
	private WebElement tableImage;
	private static final String IMG_ID = "img-";
	
	private WebElement drinkIcon;
	private static final String DRINK_ICON = "drink-icon-";
	
	private WebElement foodIcon;
	private static final String FOOD_ICON = "food-icon-";
	
	private WebElement completedDrinkNumber;
	private static final String DRINK_NUMBER = "drink-number-";
	
	private WebElement completedFoodNumber;
	private static final String FOOD_NUMBER = "food-number-";
	
	
	public TableComponent (WebDriver driver) {
		this.driver = driver;
		

	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getTableImage() {
		this.tableImage = this.driver.findElement(By.id(IMG_ID + this.tableName));
		return tableImage;
	}


	public void setTableImage(WebElement tableImage) {
		this.tableImage = tableImage;
	}


	public WebElement getDrinkIcon() {
		this.drinkIcon = this.driver.findElement(By.id(DRINK_ICON + this.tableName));
		return drinkIcon;
	}


	public void setDrinkIcon(WebElement drinkIcon) {
		this.drinkIcon = drinkIcon;
	}


	public WebElement getFoodIcon() {
		this.foodIcon = this.driver.findElement(By.id(FOOD_ICON + this.tableName));
		return foodIcon;
	}


	public void setFoodIcon(WebElement foodIcon) {
		this.foodIcon = foodIcon;
	}


	public WebElement getCompletedDrinkNumber() {
		this.completedDrinkNumber = this.driver.findElement(By.id(DRINK_NUMBER + this.tableName));
		return completedDrinkNumber;
	}


	public void setCompletedDrinkNumber(WebElement completedDrinkNumber) {
		this.completedDrinkNumber = completedDrinkNumber;
	}


	public WebElement getCompletedFoodNumber() {
		this.completedFoodNumber = this.driver.findElement(By.id(FOOD_NUMBER + this.tableName));
		return completedFoodNumber;
	}


	public void setCompletedFoodNumber(WebElement completedFoodNumber) {
		this.completedFoodNumber = completedFoodNumber;
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public void ensureTableImageIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.getTableImage()));
	}
	
}
