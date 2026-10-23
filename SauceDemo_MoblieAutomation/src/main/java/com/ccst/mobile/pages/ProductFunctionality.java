package com.ccst.mobile.pages;

import com.ccst.mobile.base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductFunctionality extends BasePage {

    private final By productPageElement = AppiumBy.id("com.saucelabs.mydemoapp.android:id/mTvTitle");

    public ProductFunctionality(AndroidDriver driver) {
        super(driver);
    }

    public boolean verifyProductPage()
    {
        waitForElementVisiblity(productPageElement);
        return true;
    }
}
