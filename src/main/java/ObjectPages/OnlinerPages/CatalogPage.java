package ObjectPages.OnlinerPages;

import ObjectPages.BasePage;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage extends BasePage {

    private String cssCatalog = ".catalog-navigation-classifier__item-title-wrapper";
    private SelenideElement input = $(byClassName("fast-search__input"));
    private WebElement frame = $(byXpath("//*[@class= 'modal-iframe']"));
    private SelenideElement checkBOX = $(byXpath("//*[@class = 'catalog-masthead-controls__input i-checkbox i-checkbox_yellow']"));
    private WebElement laptop = $(byXpath("//a[@href = 'https://catalog.onliner.by/notebook/apple/mgn63']"));
    private SelenideElement compareBtn = $(byXpath("//*[@class = 'compare-button__sub compare-button__sub_main']"));
    private SelenideElement shop = $(byXpath("//*[@data-shop-id = '3886']"));
    private SelenideElement NumberOfAppartament = $(byXpath("//* [@class = 'input-style input-style_primary input-style_base cart-form__input cart-form__input_width_xxxxs cart-form__input_nonadaptive']"));

    public CatalogPage verifyCatalog(String element) {
        SelenideElement catalogElement = $$(cssCatalog).findBy(text(element));
        catalogElement.shouldBe(visible);
        return this;
    }

    public void openLaptop() {
        enter(input, "Macbook Air 13\" M1 2020 MGN63");
        WebDriverRunner.getWebDriver().switchTo().frame(frame);
        laptop.click();
    }

    public void verifyPopUP() {
        openLaptop();
        checkBOX.shouldBe(visible, Duration.ofSeconds(10)).click();
        compareBtn.shouldBe(visible);
    }
    public void checkMaxInput () {
        openLaptop();
        shop.shouldBe(visible, Duration.ofSeconds(15)).click();
        NumberOfAppartament.shouldBe(visible,Duration.ofSeconds(10));
        enter (NumberOfAppartament,"1234567");
        Assert.assertFalse(NumberOfAppartament.getAttribute("value") == "1234567");
    }
}
