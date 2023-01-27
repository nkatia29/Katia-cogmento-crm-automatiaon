package com.cogmento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class Contacts extends HomePage{
    public Contacts(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//a[@href='/contacts/new']")
    protected WebElement createContactButton;

    public void createContact(HashMap<String,String> data) {
        //TODO
        navigate("contacts");
        createContactButton.click();


    }


}
