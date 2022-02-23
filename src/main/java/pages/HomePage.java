package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(className = "gtm-acceptDefaultCookieFirstVisit")
    private WebElement acceptCookiesButton;

    @FindBy(className = "main_nav_partners")
    private WebElement partnersButton;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public void clickAcceptCookies() {
        acceptCookiesButton.click();
    }

}
