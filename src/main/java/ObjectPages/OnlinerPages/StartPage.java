package ObjectPages.OnlinerPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterTest;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StartPage {
    private SelenideElement enterButton = $(byText("Вход"));
    private SelenideElement catalogButton = $(byXpath("//*[@class = 'b-main-navigation__text'][contains(text(),'Каталог')]"));

    public static StartPage OpenStartPage(String url) {
        open(url);
        return new StartPage();
    }
    public LoginPage ClickEnterButton() {
        enterButton.click();
        return new LoginPage();
    }
    public CatalogPage ClickCatalogButton() {
        catalogButton.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        return new CatalogPage();
    }
    @AfterTest
    public void postconditions () {
        WebDriverRunner.closeWebDriver();
    }
}
