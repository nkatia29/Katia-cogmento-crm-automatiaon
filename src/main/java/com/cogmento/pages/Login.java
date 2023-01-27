package com.cogmento.pages;

import com.cogmento.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Login extends BasePage{

    public Login(WebDriver driver, SoftAssert softAssert){
        super(driver, softAssert);
    }

    //Web elements
    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'negative message')]")
    private WebElement errorMessage;


    public void navigateToLoginPage(){
        driver.get(ConfigReader.getProperty("url"));
        softAssert.assertTrue(driver.getTitle().equals("Cogmento CRM"));
    }

    public void login(){
        emailInput.sendKeys(ConfigReader.getProperty("email"));
        passwordInput.sendKeys(ConfigReader.getProperty("password"));
        softAssert.assertTrue(loginButton.isEnabled(), "Login button is not enabled");
        loginButton.click();
    }

    public void loginNegative(){
        emailInput.sendKeys("invalid@gmail.com");
        passwordInput.sendKeys("invalidpassword!");
        softAssert.assertTrue(loginButton.isEnabled(), "Login button is not enabled");
        loginButton.click();
        softAssert.assertTrue(errorMessage.isEnabled(), "Error message is not displayed");
    }




}
