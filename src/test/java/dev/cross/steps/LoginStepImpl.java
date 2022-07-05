package dev.cross.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import dev.cross.pages.*;
import dev.cross.runner.ERSTestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepImpl {
	
	public static WebDriver driver = ERSTestRunner.driver;
	public static LoginPage loginPage = ERSTestRunner.loginPage;

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		driver.get("http://localhost:8080/login.html");
	}

	@When("the Employee types in their {string} and {string} and clicks the employee login")
	public void the_employee_types_in_creds_and_and_clicks_login(String uname, String pass) {
	    
		loginPage.username.sendKeys(uname);
		loginPage.password.sendKeys(pass);
		loginPage.loginButton.click();
	}

	@Then("the Employee should be on the home page")
	public void the_employee_should_be_on_the_home_page() {
	   
		new WebDriverWait(driver,Duration.ofSeconds(10))
		.until(ExpectedConditions.titleContains("Home Page"));
		
		assertEquals("Home Page", driver.getTitle());
		
	    
	}
	
	@When("the Employee types in the incorrect {string} or {string} and clicks the employee login")
	public void the_employee_types_in_the_incorrect_or_and_clicks_the_employee_login(String uname, String pass) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.username.sendKeys(uname);
		loginPage.password.sendKeys(pass);
		loginPage.loginButton.click();
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	@Then("the Employee should recieve an invalid credentials alert")
	public void the_employee_should_recieve_an_invalid_credentials_alert() {
	    // Write code here that turns the phrase above into concrete actions

		new WebDriverWait(driver,Duration.ofSeconds(10))
		.until(ExpectedConditions.alertIsPresent());
		
		Alert a = driver.switchTo().alert();
		
		assertEquals("Invalid Login Credentials", a.getText());
		
		a.dismiss();
		
		//expect(loginPage).to_have_selector(".alert", text: 'The text in the alert') 
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	

}