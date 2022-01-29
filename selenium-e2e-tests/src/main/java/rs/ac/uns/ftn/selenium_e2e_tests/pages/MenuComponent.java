package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuComponent {

	private WebDriver driver;
	
	@FindBy(id = "foodIcon")
	private WebElement food;
	
	@FindBy(id = "drinkIcon")
	private WebElement drink;
	
	@FindBy(id = "Coffe")
	private WebElement coffeCategory;
	
	@FindBy(id = "Americano")
	private WebElement americanoItem;
	
	@FindBy(id = "Mojito")
	private WebElement mojitoItem;
	
	@FindBy(id = "Cocktail")
	private WebElement cocktailCategory;
	
	@FindBy(id = "Pizza")
	private WebElement pizzaCategory;
	
	@FindBy(id = "Margarita")
	private WebElement margaritaItem;
	
	@FindBy(id = "Tiramisu")
	private WebElement tiramisuItem;
	
	@FindBy(id = "Dessert")
	private WebElement dessertCategory;
	
	@FindBy(className = "back-button-img")
	private WebElement backButton;
	
	
	public MenuComponent (WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void ensureElementIsClickable(WebElement element) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(element));
	}

	public void ensureFoodIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.food));
	}
	
	public void ensureDrinkIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.drink));
	}
	
	public void ensureCoffeCatIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.coffeCategory));
	}
	
	public void ensureCocktailCatIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.cocktailCategory));
	}
	
	public void ensureBackButtonIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.backButton));
	}
	
	public void ensureAmericanoIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.americanoItem));
	}
	
	public void ensureMojitoIsDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.mojitoItem));
	}

	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getFood() {
		return this.food;
	}


	public void setFood(WebElement food) {
		this.food = food;
	}


	public WebElement getDrink() {
		return this.drink;
	}


	public void setDrink(WebElement drink) {
		this.drink = drink;
	}

	public WebElement getCoffeCategory() {
		return coffeCategory;
	}

	public void setCoffeCategory(WebElement coffeCategory) {
		this.coffeCategory = coffeCategory;
	}

	public WebElement getAmericanoItem() {
		return americanoItem;
	}

	public void setAmericanoItem(WebElement americanoItem) {
		this.americanoItem = americanoItem;
	}

	public WebElement getMojitoItem() {
		return mojitoItem;
	}

	public void setMojitoItem(WebElement mojitoItem) {
		this.mojitoItem = mojitoItem;
	}

	public WebElement getCocktailCategory() {
		return cocktailCategory;
	}

	public void setCocktailCategory(WebElement cocktailCategory) {
		this.cocktailCategory = cocktailCategory;
	}

	public WebElement getBackButton() {
		return backButton;
	}

	public void setBackButton(WebElement backButton) {
		this.backButton = backButton;
	}

	public WebElement getPizzaCategory() {
		return pizzaCategory;
	}

	public void setPizzaCategory(WebElement pizzaCategory) {
		this.pizzaCategory = pizzaCategory;
	}

	public WebElement getMargaritaItem() {
		return margaritaItem;
	}

	public void setMargaritaItem(WebElement margaritaItem) {
		this.margaritaItem = margaritaItem;
	}

	public WebElement getTiramisuItem() {
		return tiramisuItem;
	}

	public void setTiramisuItem(WebElement tiramisuItem) {
		this.tiramisuItem = tiramisuItem;
	}

	public WebElement getDessertCategory() {
		return dessertCategory;
	}

	public void setDessertCategory(WebElement dessertCategory) {
		this.dessertCategory = dessertCategory;
	}
	
	
	
	
}
