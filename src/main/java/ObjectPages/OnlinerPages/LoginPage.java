package ObjectPages.OnlinerPages;

import ObjectPages.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
// log = ellenorree@gmail.com
// pass = QA07_onl2021

public class LoginPage extends BasePage {

    private WebElement username = $(byXpath("//input [@placeholder = 'Ник или e-mail']"));
    private WebElement password = $(byXpath("//input [@type = 'password']"));
    private WebElement loginBtn = $(byXpath("//button[contains(text(),'Войти')]"));
    private SelenideElement avatarLogo = $(byCssSelector("div[class='b-top-profile__image js-header-user-avatar']"));
    private SelenideElement noPasswordError = $(byXpath("//div[contains(text(),'Укажите пароль')]"));
    private SelenideElement logoutBtn = $(byXpath("//*[@class = 'b-top-profile__link b-top-profile__link_secondary'][contains(text(),'Выйти')]"));

    public LoginPage loginToApplication(String username, String password) {
        enter(this.username, username);
        enter(this.password, password);
        click(loginBtn);
        return this;
    }

    public LoginPage verifyLogin() {
        avatarLogo.shouldBe(visible, Duration.ofSeconds(15));
        return this;
    }

    public LoginPage verifyNoPasswordError() {
        noPasswordError.shouldBe(visible, Duration.ofSeconds(5));
        return this;
    }

    public void logout() {
        avatarLogo.click();
        logoutBtn.shouldBe(visible, Duration.ofSeconds(5)).click();
    }
}
