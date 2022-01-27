package rs.ac.uns.ftn.selenium_e2e_tests.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FloorLayoutComponent  {
	private WebDriver driver;
	
	@FindBy(tagName = "app-table")
	private List<WebElement> tables;
	
	@FindBy(id = "option-Floor1")
	private WebElement floor1;
	
	@FindBy(id = "option-Floor2")
	private WebElement floor2;
	
	@FindBy(id = "option-Floor3")
	private WebElement floor3;
	
	private List<TableComponent> tableComponents;

	
	@FindBy(id = "restaurant-floor")
	private WebElement floor;
	
	public FloorLayoutComponent (WebDriver driver) {
		this.driver = driver;
	}
	
	public void ensureTablesAreDisplayed() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions
				.visibilityOfAllElements(this.tables));
	}
	
	public List<WebElement> getTables() {
		return tables;
	}

	public void setTables(List<WebElement> tables) {
		this.tables = tables;
	}

	public WebElement getFloor() {
		return floor;
	}

	public void setFloor(WebElement floor) {
		this.floor = floor;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFloor1() {
		return floor1;
	}

	public void setFloor1(WebElement floor1) {
		this.floor1 = floor1;
	}

	public List<TableComponent> getTableComponents() {
		return tableComponents;
	}

	public void setTableComponents(List<TableComponent> tableComponents) {
		this.tableComponents = tableComponents;
	}


	public WebElement getFloor2() {
		return floor2;
	}


	public void setFloor2(WebElement floor2) {
		this.floor2 = floor2;
	}


	public WebElement getFloor3() {
		return floor3;
	}


	public void setFloor3(WebElement floor3) {
		this.floor3 = floor3;
	}
	
	

}
