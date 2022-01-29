package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUserPage {
	
	private WebDriver driver;
	
	@FindBy(id="inputFirstName")
	private WebElement firstNameInput;
	
	@FindBy(id="inputLastName")
	private WebElement lastNameInput;
	
	@FindBy(id="inputRole")
	private WebElement roleInput;
	
	@FindBy(id="inputSalary")
	private WebElement salaryInput;
	
	@FindBy(id="inputUsername")
	private WebElement userNameInput;
	
	@FindBy(id="inputPassword")
	private WebElement passwordInput;
	
	@FindBy(id="inputPin")
	private WebElement pinInput;
	
	@FindBy(id="submit")
	private WebElement submitButton;
	

	public NewUserPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getFirstNameInput() {
		return firstNameInput;
	}


	public void setFirstNameInput(WebElement firstNameInput) {
		this.firstNameInput = firstNameInput;
	}


	public WebElement getLastNameInput() {
		return lastNameInput;
	}


	public void setLastNameInput(WebElement lastNameInput) {
		this.lastNameInput = lastNameInput;
	}


	public WebElement getRoleInput() {
		return roleInput;
	}


	public void setRoleInput(WebElement roleInput) {
		this.roleInput = roleInput;
	}


	public WebElement getSalaryInput() {
		return salaryInput;
	}


	public void setSalaryInput(WebElement salaryInput) {
		this.salaryInput = salaryInput;
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


	public WebElement getPinInput() {
		return pinInput;
	}


	public void setPinInput(WebElement pinInput) {
		this.pinInput = pinInput;
	}


	public WebElement getSubmitButton() {
		return submitButton;
	}


	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}
	
	
}
