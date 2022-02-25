package driver;

import org.openqa.selenium.WebDriver;

/**
 * Class is responsible for holding factory methods for
 * driver handling. Creating in factory method approach - if needs any further upgrades.
 * E. g. interface to set driver options, killing driver etc.
 */

public interface DriverFactory {

    /**
     * Method creates new instance of webDriver
     *
     * @return new instance of WebDriver depending
     * on type in DriverTypes enum
     */
    WebDriver createDriver();

}
