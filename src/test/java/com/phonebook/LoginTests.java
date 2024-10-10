package com.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void loginTest() {
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("forex004@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test@12345");

        driver.findElement(By.cssSelector("input.button-1.login-button")).click();


        // Select the second product on the main page
        WebElement secondProduct = driver.findElements(By.cssSelector(".product-item")).get(1);
        secondProduct.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button")).click();

    }

}
