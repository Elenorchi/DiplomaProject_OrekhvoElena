package ObjectPages.OnlinerPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    private SelenideElement enterButton = $(byText("Вход"));
    private SelenideElement catalogButton = $(byXpath("//*[@class = 'b-main-navigation__text'][contains(text(),'Каталог')]"));

    public LoginPage ClickEnterButton() {
        enterButton.click();
        return new LoginPage();
    }
    public CatalogPage ClickCatalogButton() {
        catalogButton.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        return new CatalogPage();
    }
}
