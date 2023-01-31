import com.cogmento.BaseTest;
import com.cogmento.pages.Deals;
import com.cogmento.pages.Login;
import com.cogmento.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;


public class DealsTest extends BaseTest {



 @Test(dataProvider = "deals")
 public void dragAndDrop(HashMap<String,String> data) throws InterruptedException {
     Login login = new Login(driver, softAssert);
     Deals deals = new Deals(driver, softAssert);
     login.navigateToLoginPage();
     login.login();
     deals.verifyBoardBtn();
     deals.DragAndDrop(data);
     deals.fillOutDealPipeline(data);
     deals.deletePipeline(data);


 }
    @DataProvider(name = "deals")
    public Object[][] getContactsData(){
        return new ExcelReader("src/main/resources/testData/CogmentoTestData.xlsx", "deals").getData();
    }

}
