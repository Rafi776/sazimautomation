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

public class DeleteProduct {
	
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

        // Navigate to the dashboard page if necessary
        // driver.get("http://localhost:3000/dashboard"); // Replace with actual dashboard URL
    }
    
    @Test
    public void deleteProduct() {
        
        // Locate the trash icon using its class name
        WebElement trashIcon = driver.findElement(By.cssSelector("i.trash.icon"));

        // Click the trash icon
        trashIcon.click();
        
        // Locate the button using its class names
        WebElement modalButton = driver.findElement(By.cssSelector("body > div.ui.page.modals.dimmer.transition.visible.active > div > div.actions > button.ui.blue.button"));

        // Click the button
        modalButton.click();
    }


}
