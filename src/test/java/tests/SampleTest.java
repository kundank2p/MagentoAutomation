package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import utils.ExtentReportManager;

public class SampleTest {
    @Test
    public void testPass() {
        ExtentTest test = ExtentReportManager.getInstance().createTest("testPass");
        test.log(Status.INFO, "This test will pass.");
        // Test logic
        test.log(Status.PASS, "Test passed successfully.");
    }

    @Test
    public void testFail() {
        ExtentTest test = ExtentReportManager.getInstance().createTest("testFail");
        test.log(Status.INFO, "This test will fail.");
        // Test logic
        test.log(Status.FAIL, "Test failed intentionally.");
    }
}