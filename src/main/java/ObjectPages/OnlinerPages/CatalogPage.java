package ObjectPages.OnlinerPages;

import ObjectPages.BasePage;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage extends BasePage {

    private String cssCatalog = ".catalog-navigation-classifier__item-title-wrapper";
    private SelenideElement input = $(byClassName("fast-search__input"));
    private WebElement frame = $(byXpath("//*[@class= 'modal-iframe']"));
    private WebElement checkBOX = $(byXpath("//*[@class = 'catalog-masthead-controls__input i-checkbox i-checkbox_yellow']"));
    private WebElement laptop = $(byXpath("//a[@href = 'https://catalog.onliner.by/notebook/apple/mgn63']"));
    private SelenideElement compareBtn = $(byXpath("//*[@class = 'compare-button__sub compare-button__sub_main']"));
    private SelenideElement catalogElement = $(byCssSelector(cssCatalog));

    public CatalogPage verifyCatalog(String element) {
        SelenideElement catalogElement = $$(cssCatalog).findBy(text(element));
        catalogElement.shouldBe(visible);
        return this;
    }

    public void verifyPopUP() {
        enter(input, "Macbook Air 13\" M1 2020 MGN63");
        WebDriverRunner.getWebDriver().switchTo().frame(frame);
        laptop.click();
        checkBOX.click();
        compareBtn.shouldBe(visible);
    }
}
