package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class RegistrationSuccessPage extends BasePage<RegistrationSuccessPage> {


    @FindBy(className = "alert-success")
    private WebElement successAlert;

    public RegistrationSuccessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(isElementDisplayed(successAlert), "Success page wasn't opened");
    }

    public boolean isSuccessAlertDisplayed() {
        return isElementDisplayed(successAlert);
    }
}
