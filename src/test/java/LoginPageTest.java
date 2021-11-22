
import DriverOptions.BaseTestSelenide;
import ObjectPages.OnlinerPages.LoginPage;
import org.testng.annotations.*;

public class LoginPageTest extends BaseTestSelenide {
    LoginPage loginPage;
    protected String username = "ellenorree@gmail.com";
    protected String password = "QA07_onl2021";

    @BeforeMethod
    public void pre() {
        loginPage = startPage.ClickEnterButton();
    }

    @Test(priority = 1, description ="Test for succesful login to Onliner")
    public void succesfulLogin() {
        loginPage.loginToApplication(username, password).verifyLogin();
    }

    @Test(priority = 2, description = "Test for checking error about empty password field")
    public void failedLogin() {
        loginPage.loginToApplication(username, "").verifyNoPasswordError();
    }
}
