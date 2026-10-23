package com.ccst.mobile.pages;

import com.ccst.mobile.base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginFunctionality extends BasePage {
    private final By usernameElement = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    private final By passwordElement = AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private final By loginBtnElement = AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginBtn");
    private final By loginOptionElement = AppiumBy.accessibilityId("Login Menu Item");
    private final By usernameErrorMessage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameErrorTV");
    private final By passwordErrorMessage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV");

    public LoginFunctionality(AndroidDriver driver) {
        super(driver);
    }

    public void login(String username, String password)
    {
        clickOnViewMenuOption(loginOptionElement);
        enterValueInTextField(usernameElement,username);
        enterValueInTextField(passwordElement,password);
        driver.hideKeyboard();
        click(loginBtnElement);
    }

    public boolean validateEmptyUsernameError()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameErrorMessage)).isDisplayed();
    }

    public boolean validateEmptyPasswordError()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordErrorMessage)).isDisplayed();
    }

}
