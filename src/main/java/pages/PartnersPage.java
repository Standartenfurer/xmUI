package pages;

import managers.SetupManager;
import managers.TestDataManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static driver.DriverManager.getDriver;
import static org.testng.Assert.assertTrue;

public class PartnersPage extends BasePage<PartnersPage> {

    private final String url = SetupManager.getUrl("partners");

    @FindBy(css = "a[href='https://partners.xm.com/registration']")
    private WebElement partnerRegistrationButton;

    public PartnersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        getDriver().get(url);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(isElementDisplayed(partnerRegistrationButton), "Partner registration page was not opened");
    }

    public RegistrationPage clickPartnerRegistrationButton() {
        click(partnerRegistrationButton);
        return new RegistrationPage(getDriver());
    }

    public boolean isPartnersPageOpen() {
        return isElementDisplayed(partnerRegistrationButton);
    }

}
