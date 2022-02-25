package managers;


import org.apache.logging.log4j.Logger;

/**
 * Class is responsible for console logging execution steps.
 * Should be called only with getLogger() static method.
 * Has log4j2.xml with some basic setup
 */

public class LogManager {
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     * Method for getting logger object. Synchronised in order to avoid
     * mess in console logs while using parallel run.
     *
     * @return logger object of log4j, for console logging
     */
    public static synchronized Logger getLogger() {
        return logger;
    }

    /**
     * You really don't need this)
     */
    private LogManager() {
        throw new AssertionError();
    }

}
