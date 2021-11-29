import DriverOptions.BaseTestSelenide;
import ObjectPages.OnlinerPages.CatalogPage;
import ObjectPages.OnlinerPages.StartPage;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTestSelenide {

    CatalogPage catalog;

    @BeforeMethod
    public void precondition() {
        catalog = get(StartPage.class, "Onliner").ClickCatalogButton();
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

    @Test(description = "Test checks the ability to put bigger number of apartment exceeding max input length")
    public void checkInputLength() {
        catalog.checkMaxInput();
    }

    @Test(description = "Checking search tools, checkbox and pop-up window")
    public void popUPwindow() {
        catalog.verifyPopUP();
    }

    @AfterMethod
    public void postcondition() {
        WebDriverRunner.closeWebDriver();
    }
}
