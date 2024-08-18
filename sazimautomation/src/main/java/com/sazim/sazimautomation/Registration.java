package com.sazim.sazimautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Registration {
	
	   private WebDriver driver;

	    @BeforeEach
	    public void setUp() {
	        // Set the path to the WebDriver executable
	        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

	        // Initialize the ChromeDriver
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void validregistration() {
	        // Open teebay
	        driver.get("http://localhost:3000/register");

	        //find first name input
	        
	        WebElement firstname = driver.findElement(By.name("firstName"));
	        firstname.sendKeys("Rakibul Hasan");
	        
	        //find last name
	        WebElement lastname = driver.findElement(By.name("lastName"));
	        lastname.sendKeys("Rafi");
	        
	        //find address
	        WebElement address = driver.findElement(By.name("address"));
	        address.sendKeys("Rakibul Hasan");
	        
	        //find email
	        WebElement email = driver.findElement(By.name("email"));
	        email.sendKeys("rhrafi5@gmail.com");
	        
	        //find phone number
	        WebElement number = driver.findElement(By.name("phoneNumber"));
	        number.sendKeys("01886710531");
	        
	        //find password
	        WebElement password = driver.findElement(By.name("password"));
	        password.sendKeys("123456");
	        
	        //confirm password
	        WebElement confirmpassword = driver.findElement(By.name("confirmPassword"));
	        confirmpassword.sendKeys("123456");

	        
	        //click sign in
	        WebElement button = driver.findElement(By.cssSelector("button.ui.blue.button[type='submit']"));
	        button.click();

	        // Wait for the results page to load
	        try {
	            Thread.sleep(2000); // Sleep is not a good practice; use WebDriverWait instead
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        // Assert for error
	        assertTrue(driver.getTitle().contains("button"), "Registration failed");
	    }

	    @AfterEach
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }

}
