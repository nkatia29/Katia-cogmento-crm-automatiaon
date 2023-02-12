package com.cogmento.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class Deals extends HomePage {
    Actions actions;

    public Deals(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
        this.actions = new Actions(driver);

    }


    @FindBy(xpath = "//button[normalize-space()='Board']")
    private WebElement boardBtn;

    @FindBy(xpath = "//div[@class='ui top aligned column'][3]")
    private WebElement qualityCol;

    @FindBy(xpath = "//div[@id='main-nav']/div[@class='menu-item-wrapper']/a[@href='/deals']/i[@class='money icon']")
    private WebElement dealsBtn;

    @FindBy(xpath = "(//div[contains(@class,'ui black top attached segment')])[2]")
    private WebElement prospectCol;
    @FindBy(xpath = "(//div[contains(@class,'ui black top attached segment')])[4]")
    private WebElement researchCol;
    @FindBy(xpath = "(//button[normalize-space()='Pipeline'])[1]")
    private WebElement pipelineBtn;

    @FindBy(xpath = "//div[@class='ui multiple selection dropdown']//i[@class='dropdown icon']")
    private WebElement selectFields;

    @FindBy(xpath = "(//input[contains(@name,'pipeline_name')])[1]")
    private WebElement savePipelineAsField;

    @FindBy(xpath = "//div[@class='ui checkbox']/input[@name='save_filter']")
    private WebElement saveFilterCheckBox;

    @FindBy(xpath = "//button[@class='ui primary button'][normalize-space()='Create']")
    private WebElement createBtn;
    @FindBy (xpath = "//i[@class='trash icon']")
    private  WebElement trashBtn;
    @FindBy (xpath = "//div[@class='ui icon warning message']")
    private WebElement deletionMsg;

    @FindBy (xpath = "(//button[normalize-space()='Delete'])[1]")
    private WebElement deletebtn;
    public void verifyDealBtn() {
        navigate("deals");
        softAssert.assertTrue(dealsBtn.isDisplayed());

    }



    public void verifyBoardBtn() {
        verifyDealBtn();
        softAssert.assertTrue(boardBtn.isEnabled(), "board btn is not enabled");
        boardBtn.click();

    }

    public void DragAndDrop(HashMap<String, String> data) throws InterruptedException {

        verifyBoardBtn();
        Thread.sleep(2_000);
        WebElement firstLabelFromUnnasCol = driver.findElement(By.xpath("//div[@class='content']/a[text()='" + data.get("unassigned") + "'][1]"));
        actions.dragAndDrop(firstLabelFromUnnasCol, qualityCol);
        Thread.sleep(2_000);
        WebElement firstLabelFromProspectCol = driver.findElement(By.xpath("(//a[contains(@class,'header')][normalize-space()='" + data.get("prospect") + "'])[3]"));
        actions.dragAndDrop(firstLabelFromProspectCol, researchCol);


    }

    public void fillOutDealPipeline(HashMap<String, String> data)  {
        softAssert.assertTrue(pipelineBtn.isEnabled(), "pipeline btn is not enabled");
        pipelineBtn.click();
        selectFields.click();
        WebElement selectFieldsOptions = driver.findElement(By.xpath("//div[@class ='visible menu transition']/div/span[text()='Type']"));
        selectFieldsOptions.click();
        savePipelineAsField.sendKeys(data.get("savePipeplineAs"));
        saveFilterCheckBox.isSelected();
        softAssert.assertTrue(createBtn.isEnabled(), "create btn is not enabled");
        createBtn.click();
    }

    public void verifyPopOutMessage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = String.valueOf(js.executeScript("document.elementFromPoint(380,70)"));
        //try   try catch method
    }

 public void deletePipeline(HashMap<String, String> data){
        softAssert.assertTrue(trashBtn.isEnabled());
        trashBtn.click();
        softAssert.assertEquals(deletionMsg, "Are you sure you want to delete this record? Deleted records can be recovered via the rubbish bin", "Deletion msg doesnt match");
        if (data.get("confirmDeletion").equals("yes")){
            deletebtn.click();
        }





 }





}