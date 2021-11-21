package ObjectPages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;


public class BasePage {

    protected BasePage() {
    }

    public void open(String url) {
        WebDriverRunner.getWebDriver().get(url);
    }

    protected void enter(WebElement element, CharSequence... charSequences) {
        element.clear();
        element.sendKeys(charSequences);
    }

    protected void click(WebElement element) {
        element.click();
    }
}
