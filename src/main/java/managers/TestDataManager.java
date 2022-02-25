package managers;


import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;


/**
 * Used to generate test data: random text, emails, numbers etc.
 */
public class TestDataManager {

    private TestDataManager() {
        throw new RuntimeException("Unusable constructor");
    }

    private final static Random random = new Random();

    public static String getText() {
        return String.format("Test%s", randomNumeric(1, 2));
    }

    public static String getEmail() {
        return String.format("test%s@%s.%s",
                randomNumeric(1, 2), randomAlphabetic(6), randomAlphabetic(3));
    }

    public static int getRandomIndex(int bound) {
        return random.nextInt(bound) + 1;
    }

    public static String getNumbers() {
        return randomNumeric(6);
    }

    public static String getPassword() {
        return String.format("Aa1%s%s", randomAlphabetic(4), randomNumeric(4));
    }
}
