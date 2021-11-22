package Helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static com.codeborne.selenide.WebDriverRunner.driver;


public class Listener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        byte [] file = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(file);

    }
    @Attachment(value = "Screenshots", type = "image")
    private byte[] saveScreenshot (byte [] bytes) {
        return bytes;
    }
}