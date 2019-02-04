package com.mysecondtest.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySecondTest {

    @Test
    public void startWebDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\manto\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.linkedin.com/");

        WebElement usermailElement =driver.findElement(By.className("login-email"));

        WebElement passwordElement = driver.findElement(By.className("login-password"));

        WebElement formElement = driver.findElement(By.id("login-submit"));

        usermailElement.sendKeys("smith.10100@gmail.com");
        passwordElement.sendKeys("Mytestuserpassword");

        //passwordElement.submit(); // submit by text input element
        formElement.submit();        // submit by form element


        // Anticipate web browser response, with an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.className("resume-onboarding__title"))
        );

        // Run a test
        String message = messageElement.getText();
        String successMsg = "testusersmith, you’re almost there! Take a few minutes to finish setting up.";
        Assert.assertEquals (message, successMsg);

        // Conclude a test
        driver.quit();


    }
}
