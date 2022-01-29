package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserListComponent {
	
	private WebDriver driver;
	
	@FindBy(id="login-button")
	private List<WebElement> users;

}
