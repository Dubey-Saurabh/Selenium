package TakingScreenshotForFailedTests;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomListener extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Failed Test");
        try {
            takeScreenshotForFailedTests(result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
