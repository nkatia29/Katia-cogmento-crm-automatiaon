package com.cogmento;

import com.cogmento.driver.Driver;
import com.cogmento.pages.Login;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest{

    @Test(priority = 1)
    public void loginTestPositive(){
        extentTest = reports.startTest("Cogmento CRM login positive test");
        Login login = new Login(driver, softAssert);
        extentTest.log(LogStatus.INFO, "Created login page");
        login.navigateToLoginPage();
        extentTest.log(LogStatus.INFO, "Navigated to Login Page");
        login.login();
        extentTest.log(LogStatus.PASS, "Was able to log in with valid credentials");
    }

    @Test(priority = 2)
    public void loginTestNegative(){
        extentTest= reports.startTest("Cogmento CRM Login negative test");
        Login login = new Login(driver, softAssert);
        extentTest.log(LogStatus.INFO, "Created login page");
        login.navigateToLoginPage();
        extentTest.log(LogStatus.INFO, "Navigated to Login Page");
        login.loginNegative();
        extentTest.log(LogStatus.PASS, "Was able to log in with invalid credentials");
    }
}
