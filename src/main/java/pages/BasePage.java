package pages;

import managers.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;

import static driver.DriverManager.getDriver;
import static managers.LogManager.getLogger;

/**
 * Main class which contains all necessary actions to interact with page.
 * Great part of methods has embedded implementation of wait with different conditions
 * which are imported from class WaitManager.
 *
 * @param <T> returns the page which should be opened after interaction, in order
 *            to chain couple of actions( click().click().scroll() etc).
 */

public abstract class BasePage<T extends BasePage> extends LoadableComponent<BasePage<T>> {

    @Override
    public T get() {
        super.get();
        return (T) this;
    }

    public T click(WebElement element) {
        WaitManager.waitUntilElementClickable(element);
        getLogger().info("Clicking on: {}", element.getAttribute("class"));
        element.click();
        return (T) this;
    }

    public T noCheckClick(WebElement element) {
        getLogger().info("No check click on: {}", element.getAttribute("class"));
        element.click();
        return (T) this;
    }

    public boolean isElementDisplayed(WebElement element) {
        getLogger().info("Checking if element is displayed: {}", element);
        WaitManager.waitUntilElementDisplayed(element);
        return element.isDisplayed();
    }

    public T sendText(WebElement element, String text) {
        WaitManager.waitUntilElementDisplayed(element);
        getLogger().info("Sending text {} to field {}", text, element.getAttribute("class"));
        element.clear();
        element.sendKeys(text);
        return (T) this;
    }

    public T selectFromDropDown(WebElement dropDown, int index) {
        WaitManager.waitUntilElementDisplayed(dropDown);
        Select select = new Select(dropDown);
        getLogger().info("Selecting from {}", dropDown.getAttribute("class"));
        select.selectByIndex(index);
        return (T) this;
    }

    /**
     * direction could be better to be enum in this case...
     *
     * @param times
     * @param direction
     * @return
     */
    public T scroll(int times, String direction) {
        switch (direction.toLowerCase()) {
            case "up":
                scrollUp(times);
                break;
            case "down":
                scrollDown(times);
                break;
        }
        return (T) this;
    }

    public T scrollTo(WebElement element, int times, String direction) {
        getLogger().info("Scrolling attempt");
        for (int i = 0; i < times; i++) {
            if (isElementDisplayed(element)) {
                getLogger().info("Element found!");
                break;
            }
            scroll(1, direction);
        }
        if (!isElementDisplayed(element))
            throw new RuntimeException("Element was not found!");
        return (T) this;
    }

    /**
     * Scrolling helper method
     * @param times
     */
    private void scrollUp(int times) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        for (int i = 0; i < times; i++) {
            getLogger().info("Scrolling up");
            executor.executeScript("window.scrollBy(0,-200");
        }
    }

    /**
     * Scrolling helper method
     * @param times
     */
    private void scrollDown(int times) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        for (int i = 0; i < times; i++) {
            getLogger().info("Scrolling up");
            executor.executeScript("window.scrollBy(0,200");
        }
    }

    public boolean isTextDisplayed(String text) {
        WaitManager.waitUntilTextDisplayed(text);
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]")).isDisplayed();
    }

}
