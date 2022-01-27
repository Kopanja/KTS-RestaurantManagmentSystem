package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PinPage {
private WebDriver driver;
	
	@FindBy(id="inputPin")
	private WebElement pinInput;
	
	@FindBy(id="login-button")
	private WebElement logInSubmitButton;
	
	
	public PinPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void writePinInput(String pin) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOf(this.pinInput));
		this.pinInput.clear();
		this.pinInput.sendKeys(pin);
		
	}
	
	public void logInButtonClick() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.logInSubmitButton));
	
		this.getLogInSubmitButton().click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPinInput() {
		return pinInput;
	}

	public void setPinInput(WebElement pinInput) {
		this.pinInput = pinInput;
	}

	public WebElement getLogInSubmitButton() {
		return logInSubmitButton;
	}

	public void setLogInSubmitButton(WebElement logInSubmitButton) {
		this.logInSubmitButton = logInSubmitButton;
	}
	
	


}
