package com.cogmento;

import com.cogmento.driver.Driver;
import com.cogmento.pages.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {

    private static WebDriver driver;
    private SoftAssert softAssert;
    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
        softAssert.assertAll();
    }

    @Test
    public void loginTestPositive(){
        Login login = new Login(driver, softAssert);
        login.navigateToLoginPage();
        login.login();
    }

    @Test
    public void loginTestNegative(){
        Login login = new Login(driver, softAssert);
        login.navigateToLoginPage();
        login.loginNegative();
    }
}
