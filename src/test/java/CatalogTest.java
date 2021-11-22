import DriverOptions.BaseTestSelenide;
import ObjectPages.OnlinerPages.CatalogPage;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTestSelenide {

    CatalogPage catalog;

    @BeforeMethod
    public void precondition() {
        catalog = startPage.ClickCatalogButton();
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"Электроника"},
                {"Компьютеры и сети"},
                {"Бытовая техника"},
                {"Стройка и ремонт"},
                {"Дом и сад"},
                {"Авто и мото"}
        };
    }

    @Test(dataProvider = "data", description = "Checking the visibility of catalog elements")
    public void checkCatalogAvailability(String element) {
        catalog.verifyCatalog(element);
    }

    @Test (description = "Checking search tools, checkbox and pop-up window")
    public void popUPwindow (){
        catalog.verifyPopUP();
    }

}
