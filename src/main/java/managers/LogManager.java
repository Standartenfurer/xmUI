package managers;


import org.apache.logging.log4j.Logger;

public class LogManager {
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    public static synchronized Logger getLogger() {
        return logger;
    }

}
