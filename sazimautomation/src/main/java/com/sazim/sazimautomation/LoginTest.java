package com.sazim.sazimautomation;

import com.sazim.sazimautomation.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
	
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

        // Open the application
        driver.get("http://localhost:3000/teebay-buggy");
    }

    @Test
    public void validlogin() {
        // Perform login
        loginPage.login("testuser@teebay.com", "123456");

        // Wait for the results page to load
        try {
            Thread.sleep(2000); // Sleep is not a good practice; use WebDriverWait instead
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert that login was successful by checking the page title
        assertTrue(driver.getTitle().contains("button"), "Login failed");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
