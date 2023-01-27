package com.cogmento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private SoftAssert softAssert;
    private WebDriverWait wait;

    public HomePage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='header item']")
    protected WebElement logo;

    @FindBy(xpath = "//div[@class='header item']/following-sibling::b")
    protected WebElement orgName;

    @FindBy(xpath = "//span[@class='user-display']")
    protected WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Search']")
    protected WebElement searchInput;

    @FindBy(xpath = "(//i[@class='settings icon'])[1]")
    protected WebElement settingsGear;

    protected String settingNavigation = "//div[starts-with(@class,'menu transition')]/a//span[text()='";

    protected void logout(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Log Out']")).click();
    }

    protected void navigateToSettings(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Settings']")).click();
    }

    protected void navigateToProducts(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Products']")).click();
    }

    protected void navigateToImports(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Imports']")).click();
    }

    protected void navigateToTools(){
        settingsGear.click();
        driver.findElement(By.xpath(settingNavigation + "Tools']")).click();
    }


}
