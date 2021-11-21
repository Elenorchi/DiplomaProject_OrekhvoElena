import DriverOptions.BaseTestSelenide;
import ObjectPages.OnlinerPages.CatalogPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTestSelenide {

    CatalogPage catalog = new CatalogPage();

    @BeforeMethod
    public void precondition() {
        catalog.openCatalog();
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

    @Test(dataProvider = "data")
    public void checkCatalogAvailability(String element) {
        catalog.verifyCatalog(element);
    }

    @Test
    public void popUPwindow (){
        catalog.verifyPopUP();
    }
}
