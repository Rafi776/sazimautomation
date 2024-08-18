package com.sazim.sazimautomation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewCount {

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
    public void countview() throws InterruptedException {
        // Navigate to the browse products page
        driver.get("http://localhost:3000/browse-products");

        // Locate the product card for "Last of Us Part II PS5 game" using a CSS selector
        WebElement productCard = driver.findElement(By.xpath("//div[text()='Funshine bear']"));
        
        Thread.sleep(5000);

        // Click the product card
        productCard.click();
        
        Thread.sleep(5000);
        

        // Optional: Add assertions or further interactions here

    }

    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
