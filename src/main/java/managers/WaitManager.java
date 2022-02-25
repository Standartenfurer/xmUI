package managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static driver.DriverManager.getDriver;

/**
 * Class implementing wait methods for element handling.
 * default time set to 10 sec due to unpredictable loading time
 * after submitting registration.
 */

public class WaitManager {

    public static void waitUntilElementDisplayed(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilTextDisplayed(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));
    }

    public static void waitUntilElementClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}

