package tests;

import org.testng.annotations.Test;
import utils.ExtentReportManager;
import utils.Log;

public class SampleTest {
    @Test
    public void testPass() {
        ExtentReportManager.createTest("testPass");
        Log.info("Starting testPass.");
        // Test logic
        Log.info("Test logic executed.");
        ExtentReportManager.getTest().pass("Test passed successfully.");
    }

    @Test
    public void testFail() {
        ExtentReportManager.createTest("testFail");
        Log.info("Starting testFail.");
        // Test logic
        Log.error("Test failed intentionally.");
        ExtentReportManager.getTest().fail("Test failed intentionally.");
    }
}