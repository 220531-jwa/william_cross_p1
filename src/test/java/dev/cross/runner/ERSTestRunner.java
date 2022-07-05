package dev.cross.runner;

import java.io.File;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.*;

import dev.cross.pages.LoginPage;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = {"dev.cross.steps"})
public class ERSTestRunner {

	// we'll need a driver and an instance of our LoginPage POM
	public static WebDriver driver;
	public static LoginPage loginPage;
	
	@BeforeAll // @BeforeClass is JUnit 4
	public static void setup() {
		File edge = new File("src/test/resources/msedgedriver.exe");
		System.setProperty("webdriver.edge.driver", edge.getAbsolutePath());
		
		driver = new EdgeDriver(); 
		
		loginPage = new LoginPage(driver);
		
		System.out.println("inside setup method");
	}

	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}