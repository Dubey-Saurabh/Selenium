package RetryLogicInTestNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int retryChance = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < retryChance) {
            counter++;
            return true;
        }
        return false;
    }


}
