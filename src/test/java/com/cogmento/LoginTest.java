package com.cogmento;

import com.cogmento.driver.Driver;
import com.cogmento.pages.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest{

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
