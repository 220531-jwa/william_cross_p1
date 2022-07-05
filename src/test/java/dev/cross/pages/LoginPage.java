package dev.cross.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// This class represents the web page that we will be automating (in case of project 1 => the html pages that you create)
	// This class is what we call a POM (Page Object Model) ** not to be confused with pom.xml -> project object model
	
	// we will need an instance of our WebDriver
	private WebDriver driver;
	
	// a constructor to create an instance of this Page, and also initialize the web elements on the page
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// this next bit of code is working from the PageFactory
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "uname")
	public WebElement username;
	
	@FindBy(id = "pass")
	public WebElement password;
	
	@FindBy(id = "logButton")
	public WebElement loginButton;
	
	@FindBy(id = "mangButton")
	public WebElement managerButton;

}