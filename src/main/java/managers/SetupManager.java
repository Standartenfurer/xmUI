package managers;

import driver.DriverTypes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static managers.LogManager.getLogger;

/**
 * Used for loading properties, and some other basic settings
 */
public class SetupManager {

    private SetupManager() {
        throw new RuntimeException("Unusable constructor");
    }

    private static final String PROPERTIES = "src/main/resources/config.properties";

    private static final Properties props = new Properties();

    /**
     * Used to load property file with its data
     */
    public static void loadProperties() {
        getLogger().info("Loading properties");
        try {
            getLogger().info("Reading property file: {}", PROPERTIES);
            props.load(new FileInputStream(PROPERTIES));
            getLogger().info("Properties loaded");
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().error("Can't read property file: {}", PROPERTIES);
            throw new RuntimeException();
        }
    }


    /**
     * This one works while executing without using maven/xml file,
     * reads default driver type from property file
     *
     * @return DriverType enum of string from property file
     */
    public static DriverTypes getType() {
        getLogger().info("Getting driver type");
        if (props.isEmpty()) {
            getLogger().error("No properties found, reloading");
            loadProperties();
        }
        DriverTypes driverType;
        try {
            getLogger().info("Loading driver type");
            driverType = DriverTypes.valueOf(props.getProperty("driver"));
            getLogger().info("Driver type found: {}", driverType);
        } catch (IllegalArgumentException e) {
            getLogger().error("Unknown driver type {}", props.getProperty("driver"));
            throw new RuntimeException();
        }
        return driverType;
    }

    /**
     * This one works while maven/xml execution.
     *
     * @param type which is provided through xml file
     * @return
     */
    public static DriverTypes getType(String type) {
        DriverTypes driverType;
        try {
            getLogger().info("Loading driver type");
            driverType = DriverTypes.valueOf(type);
            getLogger().info("Driver type found: {}", driverType);
        } catch (IllegalArgumentException e) {
            getLogger().error("Unknown driver type {}", type);
            throw new RuntimeException();
        }
        return driverType;
    }

    /**
     * Returns desired url based on page description
     * @param urlResource page description with RUL
     * @return URL for provided page
     */
    public static String getUrl(String urlResource) {
        getLogger().info("Getting url for path: {}", urlResource);
        if (props.isEmpty()) {
            getLogger().error("No loaded properties found, reloading");
            loadProperties();
        }
        return props.getProperty("url." + urlResource);
    }
}
