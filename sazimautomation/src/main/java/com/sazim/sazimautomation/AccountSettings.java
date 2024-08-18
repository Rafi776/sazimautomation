package com.sazim.sazimautomation;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSettings {
	
	   private WebDriver driver;
	    private LoginPage loginPage;

	    @BeforeEach
	    public void setUp() {
	        // Set the path to the WebDriver executable
	        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

	        // Initialize the ChromeDriver
	        driver = new ChromeDriver();
	        loginPage = new LoginPage(driver);

	        // Open the application and perform login
	        driver.get("http://localhost:3000/teebay-buggy");
	        loginPage.login("testuser@teebay.com", "123456");

	    }

	    @Test
	    public void editaccount() throws InterruptedException {
	        // Navigate to the browse products page
	        driver.get("http://localhost:3000/account-settings");
	        
	        WebElement name = driver.findElement(By.name("first_name"));
	        name.clear();
	        name.sendKeys("Edited First Name");
	        
	        Thread.sleep(3000);
	        
	        WebElement lastname = driver.findElement(By.name("last_name"));
	        lastname.clear();
	        lastname.sendKeys("Edited Last Name");
	        
	        Thread.sleep(3000);
	        
	        WebElement address = driver.findElement(By.name("address"));
	        address.clear();
	        address.sendKeys("Edited Address");
	        
	        Thread.sleep(3000);
	        
	        WebElement email = driver.findElement(By.name("email"));
	        email.clear();
	        email.sendKeys("edited@gmail.com");
	        
	        Thread.sleep(3000);
	        
	        WebElement number = driver.findElement(By.name("phone_number"));
	        number.clear();
	        number.sendKeys("01234567890");
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ui.blue.button")));
	        updateButton.click();
	        
	        Thread.sleep(3000);



	    }

	    @AfterEach
	    public void tearDown() {
	        // Close the browser after each test
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
