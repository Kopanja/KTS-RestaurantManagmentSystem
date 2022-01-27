package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsernamePasswordLoginPage {

	private WebDriver driver;
	
	@FindBy(id="inputUsername")
	private WebElement userNameInput;
	
	@FindBy(id="inputPassword")
	private WebElement passwordInput;
	
	@FindBy(id="login-button")
	private WebElement logInSubmitButton;
	
	
	public UsernamePasswordLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void writeUserNameInput(String username) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOf(this.userNameInput));
		this.userNameInput.clear();
		this.userNameInput.sendKeys(username);
		
	}
	
	public void writePasswordInput(String password) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOf(this.passwordInput));
		this.passwordInput.clear();
		this.passwordInput.sendKeys(password);
		
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


	public WebElement getUserNameInput() {
		return userNameInput;
	}


	public void setUserNameInput(WebElement userNameInput) {
		this.userNameInput = userNameInput;
	}


	public WebElement getPasswordInput() {
		return passwordInput;
	}


	public void setPasswordInput(WebElement passwordInput) {
		this.passwordInput = passwordInput;
	}


	public WebElement getLogInSubmitButton() {
		return logInSubmitButton;
	}


	public void setLogInSubmitButton(WebElement logInSubmitButton) {
		this.logInSubmitButton = logInSubmitButton;
	}
	
	
	
	
}
