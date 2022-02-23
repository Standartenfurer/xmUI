package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import static managers.LogManager.getLogger;

/**
 * Enum is responsible for holding driver types for
 * WebDriver, providing implementation through WebDriverManager
 * for each type.
 */

public enum DriverTypes implements DriverFactory {

    CHROME {
        @Override
        public WebDriver createDriver() {
            getLogger().info("Setup of Chrome driver");
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        /**
         * Although all the kill methods have the same functionality, and differ
         * with only logs, they are added, in purpose if in the future you need to
         * do something with particular driver before quitting.
         * Also they prevent user from directly interacting with driver
         *
         * @param webDriver receives WebDriver instance which should be killed
         */
        @Override
        public void killDriver(WebDriver webDriver) {
            getLogger().info("Quitting Chrome driver");
            webDriver.quit();

        }
    }, FIREFOX {
        @Override
        public WebDriver createDriver() {
            getLogger().info("Creating firefox driver");
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

        @Override
        public void killDriver(WebDriver webDriver) {
            getLogger().info("Quitting Firefox driver");
            webDriver.quit();
        }
    }, EDGE {
        @Override
        public WebDriver createDriver() {
            getLogger().info("Creating Edge driver");
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }

        @Override
        public void killDriver(WebDriver webDriver) {
            getLogger().info("Quitting Edge driver");
            webDriver.quit();
        }
    }, OPERA {
        @Override
        public WebDriver createDriver() {
            getLogger().info("Creating Opera driver");
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        }

        @Override
        public void killDriver(WebDriver webDriver) {
            getLogger().info("Quitting Opera driver");
            webDriver.quit();
        }
    };

}
