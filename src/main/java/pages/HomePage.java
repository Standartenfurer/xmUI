package pages;

import managers.SetupManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;


import static driver.DriverManager.getDriver;

public class HomePage extends BasePage<HomePage> {


    @FindBy(className = "main_nav_partners")
    private WebElement partnersButton;


    private final String url = SetupManager.getUrl("base");

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        getDriver().get(url);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(isElementDisplayed(partnersButton), "Home page was not loaded");
    }

    public HomePage openPage() {
        getDriver().get(url);
        return this;
    }

    public PartnersPage clickPartnersButton() {
        click(partnersButton);
        return new PartnersPage(getDriver());
    }

}
