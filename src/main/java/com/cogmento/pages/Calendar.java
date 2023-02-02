package com.cogmento.pages;

import com.cogmento.utils.CommonUtils;
import dev.failsafe.function.CheckedRunnable;
import org.jdesktop.swingx.JXDatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static com.cogmento.utils.CommonUtils.generalRandomNumber;

public class Calendar extends HomePage {

    public Calendar(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);

    }

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    private WebElement createBtn;
    @FindBy(xpath = "//input[@name='title']")
    private WebElement title;
    @FindBy(xpath = "//div[@class='react-datepicker__input-container']/input[@type='text'][1]")
    private WebElement startDate;
    @FindBy (xpath = "(//button[@class='react-datepicker__navigation react-datepicker__navigation--next react-datepicker__navigation--next--with-time'])[1]")
    private  WebElement nextMothBtn;
    @FindBy (xpath = "(//div[@class='react-datepicker__current-month'])[1]")
    private WebElement currentMonth;
    @FindBy (xpath = "(//button[normalize-space()='Cancel'])[1]")
    private WebElement cancelBtn;
    @FindBy (css = "textarea[name='description']")
    private WebElement description;
    @FindBy (css = "textarea[name='location']")
    private WebElement location;
    @FindBy (xpath = "//div[contains(@class,'ui toggle checkbox')]")
    private WebElement allDayBtn;
    @FindBy (xpath = "//a[normalize-space()='No recurrence. Click to set.']")
    private WebElement recurrence;
    @FindBy (xpath = "//div[normalize-space()='Days']")
    private WebElement getDropDownDays;
    @FindBy (xpath = "(//button[normalize-space()='Set'])[1]")
    private  WebElement setBtn;
    @FindBy (xpath = "//div[contains(@name,'freq')]//i[contains(@class,'dropdown icon')]")
    private WebElement dropDownIcon;
    @FindBy (xpath =  "//button[@class='ui linkedin button']")
    private  WebElement saveBtn;
    @FindBy (xpath = "//i[@class='comments outline icon']")
    private WebElement addNotesBtn;
    @FindBy (xpath = "//form[@class='ui form']//textarea")
    private WebElement textArea;
    @FindBy (xpath = "//button[@class='ui green button']")
    private WebElement greenSaveBtn;









    public void createNewEvent(HashMap<String, String> data) throws InterruptedException {
        navigate("calendar");
        softAssert.assertTrue(createBtn.isEnabled());
        createBtn.click();
        Thread.sleep(1_000);

        driver.navigate().refresh();
        Thread.sleep(1_000);


        title.sendKeys(data.get("title"));
        startDate.click();
        nextMothBtn.click();
        driver.findElement(By.xpath("(//div[contains(@class,'react-datepicker__day react-datepicker__day--0"+generalRandomNumber(11,25)+"')])[1]")).isSelected();
        driver.findElement(By.xpath("(//li[normalize-space()='" + generalRandomNumber(11, 24) + ":45'])[1]")).click();
        description.sendKeys(data.get("description"));
        location.sendKeys(data.get("location"));
        allDayBtn.click();
        recurrence.click();
        dropDownIcon.click();
        driver.findElement(By.xpath("//span[normalize-space()='"+data.get("interval")+"']")).click();
        driver.findElement((By.xpath("//div[contains(@name,'byweekday')]//i[contains(@class,'dropdown icon')]"))).click();
        driver.findElement((By.xpath("//div[@role='option']/span[text()='"+data.get("days")+"']"))).click();
        driver.findElement(By.xpath("(//i[contains(@class,'dropdown icon')])[7]")).click();

        softAssert.assertTrue(setBtn.isEnabled());
        setBtn.click();

        softAssert.assertTrue(saveBtn.isEnabled());
        saveBtn.click();

    }
    public void addNotes(HashMap<String,String> data){
        softAssert.assertTrue(addNotesBtn.isEnabled()," add note btn is not enabled");
        addNotesBtn.click();
        textArea.sendKeys(data.get("addNote"));
        softAssert.assertTrue(greenSaveBtn.isEnabled(),"save note btn is not enabled");
        greenSaveBtn.click();

 }




}








