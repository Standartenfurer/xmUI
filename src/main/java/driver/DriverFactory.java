package driver;

import org.openqa.selenium.WebDriver;

/**
 * Class is responsible for holding factory methods for
 * driver handling.
 */

public interface DriverFactory {

    /**
     * Method creates new instance of webDriver
     *
     * @return new instance of WebDriver depending
     * on type in DriverTypes enum
     */
    WebDriver createDriver();

    /**
     *
     */

    /**
     * Ends session for the WebDriver
     *
     * @param webDriver receives WebDriver instance which should
     *                  be closed
     */
    void killDriver(WebDriver webDriver);


}
