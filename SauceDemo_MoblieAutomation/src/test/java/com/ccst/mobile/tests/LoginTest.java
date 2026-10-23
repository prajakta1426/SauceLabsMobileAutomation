package com.ccst.mobile.tests;

import com.ccst.mobile.base.BaseTest;
import com.ccst.mobile.pages.LoginFunctionality;
import com.ccst.mobile.pages.ProductFunctionality;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginFunctionality loginFunctionality;
    ProductFunctionality productFunctionality;

    @BeforeMethod
    public void initPage() {
        loginFunctionality = new LoginFunctionality(driver);
        productFunctionality = new ProductFunctionality(driver);
    }

    @Test(priority = 3)
    public void validLoginValidation(){
        loginFunctionality.login("bod@example.com","10203040");
        Assert.assertTrue(productFunctionality.verifyProductPage());
    }

    @Test(priority = 2)
    public void emptyUsernameLoginValidation()
    {
        loginFunctionality.login("","102030000");
        boolean isUsernameErrorDisplayed = loginFunctionality.validateEmptyUsernameError();
        Assert.assertTrue(isUsernameErrorDisplayed);
    }

    @Test(priority = 1)
    public void emptyPasswordLoginValidation()
    {
        loginFunctionality.login("dsfr","");
        boolean isPasswordErrorDisplayed = loginFunctionality.validateEmptyPasswordError();
        Assert.assertTrue(isPasswordErrorDisplayed);
    }

}
