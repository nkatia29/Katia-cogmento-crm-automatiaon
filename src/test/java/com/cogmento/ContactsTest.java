package com.cogmento;

import com.cogmento.pages.Contacts;
import com.cogmento.pages.Login;
import com.cogmento.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ContactsTest extends BaseTest{

    @Test(dataProvider = "contacts")
    public void createContactPositive(HashMap<String,String> data) throws InterruptedException {
        Login login = new Login(driver, softAssert);
        Contacts contacts = new Contacts(driver, softAssert);

        login.navigateToLoginPage();
        login.login();
        contacts.createContact(data);
        Thread.sleep(5000);
    }

    @DataProvider(name = "contacts")
    public Object[][] getContactsData(){
        return new ExcelReader("src/main/resources/testData/CogmentoTestData.xlsx", "contacts").getData();
    }
}
