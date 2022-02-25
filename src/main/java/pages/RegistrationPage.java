package pages;

import managers.SetupManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static driver.DriverManager.getDriver;
import static org.testng.Assert.assertTrue;

public class RegistrationPage extends BasePage<RegistrationPage> {

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

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "state_region")
    private WebElement regionField;

    @FindBy(id = "street_name")
    private WebElement streetNameField;

    @FindBy(id = "street_number")
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

    @FindBy(id = "agree_terms")
    private WebElement agreeTermsCheckbox;

    @FindBy(id = "submit-btn")
    private WebElement submitButton;

    @FindBy(id = "js-riskCloseButton")
    private WebElement riskCloseButton;

    private final String termsErrorMessage = "To register a Real Account, you must accept all applicable Terms and Conditions";

    private final String url = SetupManager.getUrl("signUp");

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @Override
    protected void load() {
        getDriver().get(url);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(isElementDisplayed(firstNameField), "Registration page was not loaded");
    }

    public RegistrationPage setName(String name) {
        return sendText(firstNameField, name);
    }

    public RegistrationPage setLastName(String lastName) {
        return sendText(lastNameField, lastName);
    }

    public RegistrationPage setDay(int dayIndex) {
        return selectFromDropDown(dayDropDown, dayIndex);
    }

    public RegistrationPage setMonth(int monthIndex) {
        return selectFromDropDown(monthDropDown, monthIndex);
    }

    public RegistrationPage setYear(int yearIndex) {
        return selectFromDropDown(yearDropDown, yearIndex);
    }

    public RegistrationPage setCountry(int index) {
        scrollTo(countryDropDown, 3, "down");
        return selectFromDropDown(countryDropDown, index);
    }

    public RegistrationPage scrollToAddress() {
        return scrollTo(streetNameField, 5, "down");
    }

    public RegistrationPage setCityName(String name) {
        return sendText(cityField, name);
    }

    public RegistrationPage setRegionName(String name) {
        return sendText(regionField, name);
    }

    public RegistrationPage setAddress(String name) {
        return sendText(streetNameField, name);
    }

    public RegistrationPage setStreetNumber(String number) {
        return sendText(streetNumberField, number);
    }

    public RegistrationPage setZipCode(String number) {
        return sendText(zipCodeField, number);
    }

    public RegistrationPage scrollToPhoneField() {
        return scrollTo(phoneNumber, 5, "down");
    }

    public RegistrationPage setPhoneCode(int index) {
        scrollTo(prefixDropDown, 3, "down");
        return selectFromDropDown(prefixDropDown, index);
    }

    public RegistrationPage setPhoneNumber(String number) {
        return sendText(phoneNumber, number);
    }

    public RegistrationPage setEmail(String email) {
        return sendText(emailField, email);
    }

    public RegistrationPage scrollToLanguageSection() {
        return scrollTo(languageDropDown, 5, "down");
    }

    public RegistrationPage setPreferredLanguage(int index) {
        return selectFromDropDown(languageDropDown, index);
    }

    public RegistrationPage scrollToSubmitButton() {
        return scrollTo(submitButton, 5, "down");
    }

    public RegistrationPage setPassword(String password) {
        return sendText(passwordField, password);
    }

    public RegistrationPage confirmPassword(String password) {
        return sendText(passwordConfirmationField, password);
    }

    public RegistrationPage setAgreeTermsCheckbox() {
        return noCheckClick(agreeTermsCheckbox);
    }

    public RegistrationSuccessPage clickSubmitButton() {
        click(submitButton);
        return new RegistrationSuccessPage(getDriver());
    }

    public boolean isRegistrationPageOpened() {
        return isElementDisplayed(firstNameField);
    }

    public boolean isTermsConditionsWarningAppeared() {
        return isTextDisplayed(termsErrorMessage);
    }

    public RegistrationPage clickRiskCloseButton() {
        return click(riskCloseButton);
    }

}
