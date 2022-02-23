package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnersPage extends BasePage {

    @FindBy(css = "a[href='https://partners.xm.com/registration']")
    private WebElement partnerRegistrationButton;

    public PartnersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public boolean isButtonDisplayed() {
        return partnerRegistrationButton.isDisplayed();
    }
}
