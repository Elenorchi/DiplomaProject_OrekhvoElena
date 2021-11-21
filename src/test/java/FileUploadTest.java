import DriverOptions.BaseTestSelenide;
import ObjectPages.OnlinerPages.LoginPage;
import ObjectPages.OnlinerPages.UploadPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTestSelenide {

    UploadPage upload = new UploadPage();
    LoginPage login;
    protected String username = "ellenorree@gmail.com";
    protected String password = "QA07_onl2021";

    @Test
    public void uploadPicture() {
        login = startPage.ClickEnterButton().loginToApplication(username,password );
        upload.uploadPicture();
    }

}
