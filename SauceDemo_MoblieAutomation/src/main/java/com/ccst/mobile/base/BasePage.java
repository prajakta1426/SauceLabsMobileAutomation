package com.ccst.mobile.base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public AndroidDriver driver;
    public WebDriverWait wait;
    By viewMenu = AppiumBy.id("com.saucelabs.mydemoapp.android:id/menuIV");

    public BasePage(AndroidDriver driver)
    {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void clickOnViewMenuOption(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void enterValueInTextField(By locator, String value)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
    }

    public void click(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitForElementVisiblity(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
