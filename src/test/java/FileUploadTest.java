import DriverOptions.BaseTestSelenide;
import ObjectPages.OnlinerPages.LoginPage;
import ObjectPages.OnlinerPages.StartPage;
import ObjectPages.OnlinerPages.UploadPage;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTestSelenide {

    UploadPage upload = new UploadPage();
    LoginPage login;
    protected String username = "ellenorree@gmail.com";
    protected String password = "QA07_onl2021";

    @BeforeMethod
    public void pre() {
        login = get (StartPage.class, "Onliner").ClickEnterButton();
    }

    @Test (description = "Checking ability to upload profile photo ")
    public void uploadPicture() {
        login.loginToApplication(username,password );
        upload.uploadPicture();
        login.logout();
    }
    @AfterMethod
    public void postcondition () {
        WebDriverRunner.closeWebDriver();
    }

}
