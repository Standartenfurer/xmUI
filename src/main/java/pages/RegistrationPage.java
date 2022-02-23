package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "dob_day")
    private WebElement dayDropDown;

    @FindBy(id = "dob_month")
    private WebElement monthDropDown;

    @FindBy(id = "dob_year")
    private WebElement yearDropDown;

    @FindBy(id = "country")
    private WebElement countryDropDown;

    @FindBy(id="City")
    private WebElement cityField;

    @FindBy(id = "state_region")
    private WebElement regionField;

    @FindBy(id = "street_name")
    private WebElement streetNameField;

    @FindBy(id  = "street_number")
    private WebElement streetNumberField;

    @FindBy(id = "postal_zip")
    private WebElement zipCodeField;

    @FindBy(id = "phoneNumberCountryPrefix")
    private WebElement prefixDropDown;

    @FindBy(id = "phone_number")
    private WebElement phoneNumber;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "preferred_language")
    private WebElement languageDropDown;

    @FindBy(id = "account_password")
    private WebElement passwordField;

    @FindBy(id = "account_password_confirmation")
    private WebElement passwordConfirmationField;






    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
