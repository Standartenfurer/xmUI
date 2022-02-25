package registration;

import managers.TestDataManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static driver.DriverManager.getDriver;
import static managers.TestDataManager.getPassword;
import static org.testng.Assert.assertTrue;

public class RegistrationFlowTest extends BaseTest {

    @BeforeMethod
    private void testSetup() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openPage();
        new CookieComponent(getDriver()).get().clickAcceptCookies();
    }


    @Test
    public void functionalityOfRegistrationFlow() {
        RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage(getDriver());
        HomePage homePage = new HomePage(getDriver()).get();
        PartnersPage partnersPage = homePage.clickPartnersButton().get();
        assertTrue(partnersPage.isPartnersPageOpen(), "Partners page was not opened!");
        RegistrationPage registrationPage = partnersPage.clickPartnerRegistrationButton().get();
        assertTrue(registrationPage.isRegistrationPageOpened(), "Registration page was not opened!");
        registrationPage.clickRiskCloseButton();
        registrationPage.setName(TestDataManager.getText()).
                setLastName(TestDataManager.getText()).
                setDay(TestDataManager.getRandomIndex(10)).
                setMonth(TestDataManager.getRandomIndex(10)).
                setYear(TestDataManager.getRandomIndex(10)).
                scrollToAddress().
                setCountry(TestDataManager.getRandomIndex(10));
        registrationPage.
                setCityName(TestDataManager.getText()).
                setRegionName(TestDataManager.getText()).
                setAddress(TestDataManager.getText()).
                setStreetNumber(TestDataManager.getNumbers()).
                setZipCode(TestDataManager.getNumbers()).
                scrollToPhoneField().
                setPhoneCode(TestDataManager.getRandomIndex(10)).
                setPhoneNumber(TestDataManager.getNumbers()).
                setEmail(TestDataManager.getEmail()).
                scrollToLanguageSection().
                setPreferredLanguage(TestDataManager.getRandomIndex(10)).
                scrollToSubmitButton();
        final String password = getPassword();
        registrationPage.setPassword(password).
                confirmPassword(password);
        registrationPage.clickSubmitButton();
        assertTrue(registrationPage.isTermsConditionsWarningAppeared(), "Terms and conditions warning did not appear");

        registrationPage.setAgreeTermsCheckbox().
                clickSubmitButton();
        assertTrue(registrationSuccessPage.get().isSuccessAlertDisplayed(), "Registration was not completed successfully");
    }
}
