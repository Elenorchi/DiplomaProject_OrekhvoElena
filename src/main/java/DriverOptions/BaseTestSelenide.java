package DriverOptions;

import ObjectPages.Listener;
import ObjectPages.OnlinerPages.StartPage;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Configuration.timeout;;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.Configuration.browserSize;

@Listeners(Listener.class)
public abstract class BaseTestSelenide {
    protected StartPage startPage;
    String startPageUrl = "https://www.onliner.by/";


    @BeforeTest
    public void SetUpBrowser() {
        browserSize = "1800x1000";
        timeout = 5000;
    }

    @BeforeMethod
    public void OpenStartPage() {
        startPage = StartPage.OpenStartPage(startPageUrl);
    }

    @AfterTest
    public void closeDriver() {
        if (driver() != null) {
            WebDriverRunner.getWebDriver().close();
        }
    }
}
