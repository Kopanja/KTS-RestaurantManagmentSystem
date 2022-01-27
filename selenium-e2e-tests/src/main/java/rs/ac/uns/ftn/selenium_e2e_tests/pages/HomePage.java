package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(id = "usrn-pass-login-button")
	private WebElement usrnamePassButton;
	
	@FindBy(id = "pin-login-button")
	private WebElement pinButton;

	public HomePage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void usernamePassButtonClick() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.usrnamePassButton));
	
		this.getUsrnamePassButton().click();
	}
	
	public void pinButtonClick() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.elementToBeClickable(this.pinButton));
	
		this.getPinButton().click();
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsrnamePassButton() {
		return usrnamePassButton;
	}

	public void setUsrnamePassButton(WebElement usrnamePassButton) {
		this.usrnamePassButton = usrnamePassButton;
	}

	public WebElement getPinButton() {
		return pinButton;
	}

	public void setPinButton(WebElement pinButton) {
		this.pinButton = pinButton;
	}
	
	
	
	
}
