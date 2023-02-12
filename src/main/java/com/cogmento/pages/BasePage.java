package com.cogmento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage {

    public static WebDriver driver;
    protected SoftAssert softAssert;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        this.actions = new Actions(this.driver);
        PageFactory.initElements(driver, this);

    }



}
