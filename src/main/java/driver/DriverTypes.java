package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
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

    }, FIREFOX {
        @Override
        public WebDriver createDriver() {
            getLogger().info("Creating firefox driver");
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    }, EDGE {
        @Override
        public WebDriver createDriver() {
            getLogger().info("Creating Edge driver");
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }

    }, OPERA {
        @Override
        public WebDriver createDriver() {
            getLogger().info("Creating Opera driver");
            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        }

    }

}
