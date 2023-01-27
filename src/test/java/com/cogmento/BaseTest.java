package com.cogmento;

import com.cogmento.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown(){
//        Driver.quitDriver();
//        softAssert.assertAll();
    }
}
