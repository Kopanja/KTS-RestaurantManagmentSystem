package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenagerPage {
private WebDriver driver;
	
	@FindBy(tagName = "tr")
	private List<WebElement> users;
	
	public MenagerPage (WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getUsers() {
		return users;
	}

	public void setUsers(List<WebElement> users) {
		this.users = users;
	}
	
	public void ensureUsersAreDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOfAllElements(this.users));
	}

}
