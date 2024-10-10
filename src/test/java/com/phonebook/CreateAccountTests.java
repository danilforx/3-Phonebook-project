package com.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void createNewAccount() {
        // click on register link class="ico-register"
        driver.findElement(By.className("ico-register")).click();

        // register new user
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("David");
        driver.findElement(By.id("LastName")).sendKeys("Smith");

        driver.findElement(By.id("Email")).sendKeys("forex016@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test@12345");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Test@12345");

        driver.findElement(By.id("register-button")).click();

        driver.findElement(By.cssSelector("input.button-1.register-continue-button")).click();

        // Select the second product on the main page
        WebElement secondProduct = driver.findElements(By.cssSelector(".product-item")).get(1);
        secondProduct.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button")).click();

        driver.findElement(By.xpath("//a[text()='shopping cart']")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();



    }


    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

}
