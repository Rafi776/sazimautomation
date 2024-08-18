package com.sazim.sazimautomation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddProduct {

    private WebDriver driver;
    private LoginPage loginPage;

    // Product details for different products
    private final String[][] products = {
        {"iPhone 15 Pro Max", "Testing by Rafi 1", "1000", "5", "Daily"},
        {"Samsung Galaxy S21", "Testing by Rafi 2", "800", "4", "Weekly"},
        {"Google Pixel 6", "Testing by Rafi 3", "700", "3", "Monthly"},
        {"OnePlus 9", "Testing by Rafi 4", "600", "2", "Hourly"},
        {"Sony Xperia 1", "Testing by Rafi 5", "900", "6", "Daily"}
    };

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
    public void addMultipleProducts() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on "My Products" link
        WebElement myProductsLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.active.item")));
        myProductsLink.click();

        // Add each product
        for (String[] product : products) {
            addProduct(product);
            Thread.sleep(2000); // Wait for 10 seconds after adding each product
        }

        // After adding products, navigate to "My Products" page
        driver.get("http://localhost:3000/my-products"); // Replace with actual URL if different
    }

    public void addProduct(String[] productDetails) {
        driver.get("http://localhost:3000/add-product");

        // Extract product details
        String titleText = productDetails[0];
        String descriptionText = productDetails[1];
        String priceValue = productDetails[2];
        String rentValue = productDetails[3];
        String rentDuration = productDetails[4];

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        // Title
        WebElement title = driver.findElement(By.name("title"));
        title.sendKeys(titleText);

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ui.multiple.selection.dropdown")));
        dropdown.click(); // Click to expand the dropdown

        // Locate and click on a specific item
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='item' and .//span[text()='Electronics']]")));
        item.click();

        // Locate the <textarea> element
        WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea.sc-gEvEer.hKGfSv")));
        textArea.sendKeys(descriptionText);

        // Input price
        WebElement price = driver.findElement(By.name("purchase_price"));
        price.sendKeys(priceValue);

        // Input rent price
        WebElement rent = driver.findElement(By.name("rent_price"));
        rent.sendKeys(rentValue);

        // Locate and click the dropdown icon to expand the dropdown
        WebElement dropdownIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='dropdown icon'])[2]")));
        dropdownIcon.click(); // Click to expand the dropdown

        WebElement rentitem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + rentDuration + "']")));
        rentitem.click();

        // Locate the "Add Product" button and click it
        WebElement addProductButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ui.blue.button")));
        addProductButton.click();
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
