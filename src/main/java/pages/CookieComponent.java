package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

/**
 * The best approach would be to implement separate component like BaseComponent
 * as it doesn't require few methods (e.g. load()). Was not implemented due to lack
 * of usage and time.
 */

public class CookieComponent extends BasePage<CookieComponent> {

    @FindBy(className = "cookie-modal__defaultBlock")
    private WebElement cookiePopup;

    @FindBy(className = "gtm-acceptDefaultCookieFirstVisit")
    private WebElement acceptCookiesButton;

    public CookieComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        throw new RuntimeException("Component has no url specified");
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(isElementDisplayed(cookiePopup), "Accept cookies pop up doesn't appear");
    }

    public void clickAcceptCookies() {
        click(acceptCookiesButton);
    }
}
