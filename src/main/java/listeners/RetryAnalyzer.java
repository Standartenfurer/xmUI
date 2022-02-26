package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static managers.LogManager.getLogger;

public class RetryAnalyzer implements IRetryAnalyzer {
    private final int maxRetry = 2;
    private int currentRetry = 0;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentRetry < maxRetry && !iTestResult.isSuccess()) {
            getLogger().warn("Test: {} failed, retrying.", iTestResult.getTestName());
            currentRetry++;
            getLogger().info("Current retry No: {}", currentRetry);
            System.out.println(currentRetry < maxRetry);
            return true;
        }
        if (currentRetry == maxRetry)
            getLogger().error("Max retry reached!");
        return false;
    }
}
