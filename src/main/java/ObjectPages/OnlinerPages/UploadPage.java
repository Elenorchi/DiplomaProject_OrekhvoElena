package ObjectPages.OnlinerPages;

import ObjectPages.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UploadPage extends BasePage {

    private SelenideElement avatarLogo = $(byCssSelector("div[class='b-top-profile__image js-header-user-avatar']"));
    private String link = "C:\\Users\\DiplomaProject_OrekhvoElena-master\\src\\main\\java\\Files\\115-1150092_png-file-person-icon.png";
    private SelenideElement avatar = $(byXpath("//*[@class='profile-header__image profile-header__image_person profile-header__image_person_1']"));
    private SelenideElement profileID = $(byXpath("//*[@class ='b-top-profile__header']//a[contains (text(), '3386707')]"));
    private SelenideElement uploadingButton  =  $(byXpath("//*[@accept = 'image/x-png,image/png,image/jpeg,image/gif,.jpeg,.jpg,.png,.gif']"));
    private SelenideElement saveButton = $(byXpath("//*[contains (text(), 'Сохранить')]  "));

    public UploadPage uploadPicture() {
        avatarLogo.click();
        profileID.click();
        avatar.click();
        uploadingButton.sendKeys(link);
        saveButton.click();
        return this;
    }

}
