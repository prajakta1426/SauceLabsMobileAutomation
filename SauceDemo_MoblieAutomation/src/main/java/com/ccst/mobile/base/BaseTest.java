package com.ccst.mobile.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public abstract class BaseTest {
    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp(){
        try {
            UiAutomator2Options options= new UiAutomator2Options()
                .setDeviceName("Vivo emulator")
                .setApp("C:\\Users\\CCST\\AutomationFramewrork\\SauceDemo_MoblieAutomation\\apps\\mda-2.3.0-27.apk");
            driver = new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
