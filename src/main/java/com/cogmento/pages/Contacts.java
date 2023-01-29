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

    @FindBy(name = "first_name")
    protected WebElement firstNameInput;

    @FindBy(name = "middle_name")
    protected WebElement middleNameInput;

    @FindBy(xpath = "//label[text()='Access']/following-sibling::div//button")
    protected WebElement accesBtn;

    @FindBy(xpath = "//div[text()='Select users allowed access']/following-sibling::div/div")
    protected WebElement accessAllowedUsersDropDown;


    @FindBy(xpath = "//input[@placeholder='Email address']")
    protected WebElement emailInput;


    @FindBy(xpath = "//label[text()='Status']/following-sibling::div")
    protected WebElement statusDropDown;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div/div/div[1]")
    protected WebElement socialChannelDropDown;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div/div/div[2]//input")
    protected WebElement socialChannelInput;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div/div/div[3]/button")
    protected WebElement socialChannelAddBtn;

    @FindBy(name = "address")
    protected WebElement addressInput;

    @FindBy(name = "city")
    protected WebElement cityInput;

    @FindBy(name="state")
    protected WebElement stateIput;

    @FindBy(name = "zip")
    protected WebElement zipInput;

    @FindBy(name = "country")
    protected WebElement countryDropDown;

    @FindBy(name = "position")
    protected WebElement positionInput;

    @FindBy(xpath = "//label[text()='Supervisor']/following-sibling::div/input")
    protected WebElement supervisorInput;

    @FindBy(xpath = "//label[text()='Referred By']/following-sibling::div/input")
    protected WebElement referredByInput;

    @FindBy(xpath = "//label[text()='Do not Call']/following-sibling::div/input")
    protected WebElement doNotCallRadioBtn;

    @FindBy(xpath = "//label[text()='Do not Email']/following-sibling::div/input")
    protected WebElement doNotEmailRadioBtn;

    @FindBy(name = "identifier")
    protected WebElement identifierInput;

    @FindBy(name = "last_name")
    protected WebElement lastNameInput;

    @FindBy(name = "company")
    protected WebElement companyInput;

    @FindBy(xpath = "//label[@for='tags']/div/input")
    protected WebElement tagsInput;

    @FindBy(name = "category")
    protected WebElement categoryDropDown;

    @FindBy(name = "description")
    protected WebElement descriptionTextArea;

    @FindBy(xpath = "//div[@name='timezone']/input")
    protected WebElement timeZoneInput;

    @FindBy(xpath = "//div[@name='hint']/div[2]")
    protected WebElement phoneRegionDropDown;

    @FindBy(xpath = "//input[@placeholder='Number']")
    protected WebElement phoneNumberInput;

    @FindBy(xpath ="//input[@placeholder='Home, Work, Mobile...']" )
    protected WebElement phoneType;

    @FindBy(xpath = "//label[text()='Phone']/following-sibling::div//button")
    protected WebElement addPhoneBtn;

    @FindBy(name = "department")
    protected WebElement departmentInput;

    @FindBy(xpath = "//div[@name='assistant']/input")
    protected WebElement assistantInput;

    @FindBy(xpath = "//label[text()='Source']/following-sibling::div")
    protected WebElement sourceDropDown;


    @FindBy(xpath = "//label[text()='Do not Text']/following-sibling::div/input")
    protected WebElement doNotTextRadioBtn;

    @FindBy(xpath = "//input[@placeholder='Day' and @name='day']")
    protected WebElement birthDayInput;

    @FindBy(xpath = "//div[text()='Month']")
    protected WebElement birthMonthDropDown;

    @FindBy(xpath = "//input[@placeholder='Year' and @name='year']")
    protected WebElement birthYearInput;

    @FindBy(xpath = "//input[@name='image']")
    protected WebElement imagePathInput; //we need to send the path of the picture based on the OS

    @FindBy(xpath = "//button[text()='Save']")
    protected WebElement saveCustomerBtn;

    @FindBy(xpath = "//button[text()='Cancel']")
    protected WebElement cancelSaveBtn;

    public void createContact(HashMap<String,String> data) {
        navigate("contacts");
        softAssert.assertTrue(createContactButton.isEnabled(), "Create button is not enabled");

    }


}
