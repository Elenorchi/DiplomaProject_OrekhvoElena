
import DriverOptions.BaseTestSelenide;
import ObjectPages.OnlinerPages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTestSelenide {
    LoginPage loginPage;
    protected String username = "ellenorree@gmail.com";
    protected String password = "QA07_onl2021";

    @BeforeMethod
    public void pre() {
        loginPage = startPage.ClickEnterButton();
    }

    @Test(priority = 1, description = "Test for succesful login to Onliner.by")
    public void succesfulLogin() {
        loginPage.loginToApplication(username, password).verifyLogin();
        loginPage.logout();
    }

    @Test(priority = 2, description = "Test for checking error about empty password field")
    public void noPasswordError() {
        loginPage.loginToApplication(username, "").verifyNoPasswordError();
    }

    @Test(priority = 2, description = "Test for checking error about incorrect password")
    public void incorrectPasswordError() {
        loginPage.loginToApplication(username, "somestring").verifyIncorrectPasswordError();
    }
}
