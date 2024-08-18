package com.sazim.sazimautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        // Find email input
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys(email);
        
        // Find password input
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
        
        // Click sign in button
        WebElement signInButton = driver.findElement(By.cssSelector("button.ui.blue.button[type='submit']"));
        signInButton.click();
    }

}
