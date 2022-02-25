package registration;

import driver.DriverManager;
import managers.SetupManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Class used for for test initial setup, including driver creation and killing
 */
public abstract class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void initDriver(@Optional String browser) {
        SetupManager.loadProperties();
        DriverManager.init(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.killDriver();
    }


}
