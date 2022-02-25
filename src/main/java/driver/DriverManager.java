package driver;

import managers.SetupManager;
import org.openqa.selenium.WebDriver;

import static managers.LogManager.getLogger;

/**
 * Class which actually provides interface(methods) of driver interaction
 * hiding driver type setup, killing process behind DriverFactory and DriverManager.
 * ThreadLocals used in a way to avoid problems with synchronization and overriding drivers by
 * different threads
 */
public class DriverManager {
    /**
     * ThreadLocal usage needed to avoid drivers overriding during parallel execution
     */
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * For storing driver type
     */
    private static final ThreadLocal<DriverTypes> driverType = new ThreadLocal<>();

    /**
     * Used as a driver instance for page interaction
     *
     * @return instance of webdriver
     */
    public static WebDriver getDriver() {
        getLogger().info("Getting driver");
        if (driver.get() == null || driverType.get() == null) {
            getLogger().warn("Driver or driver type not found. Creating new instance");
            driverType.set(getDriverType());
            driver.set(driverType.get().createDriver());
        }
        return driver.get();
    }

    /**
     * !!!Invoked while single test run (via play button)!!!
     * @return Reads and return driver type from property file
     */
    public static DriverTypes getDriverType() {
        getLogger().info("Getting driver type from property file");
        return SetupManager.getType();
    }


    /**
     * !!!Invoked while executing test via maven/test xml
     * @param type required driver type
     * @return
     */
    public static DriverTypes getDriverType(String type) {
        getLogger().info("Getting driver type from XML file");
        return SetupManager.getType(type);
    }

    /**
     * Used for driver initialization for test starting.
     * Moved to other method from getDriver if needs further upgrades
     * @param browserType
     */
    public static void init(String browserType) {
        getLogger().info("Driver initialization");
        if (browserType == null) {
            getLogger().info("No driver type found, reading from config file");
            driverType.set(getDriverType());
        } else {
            getLogger().info("Setting driver type from XML");
            driverType.set(getDriverType(browserType));
        }
        driver.set((driverType.get().createDriver()));
    }

    /**
     * Used to safely remove ThreadLocal and Kill driver
     */
    public static void killDriver() {
        driver.get().quit();
        getLogger().info("Quiting driver: {}", driver.get());
        driver.remove();
        getLogger().info("Removing thread");
        driverType.remove();
        getLogger().info("Removing type:");
    }


}
