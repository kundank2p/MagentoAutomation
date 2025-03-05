package listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;

public class ExtentTestNGListener implements ITestListener {
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        // Initialize the Extent Report
        ExtentReportManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a test in the report
        ExtentTest extentTest = ExtentReportManager.getInstance()
                .createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test as passed
        test.get().log(Status.PASS, MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test as failed
        test.get().log(Status.FAIL, MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
        test.get().fail(result.getThrowable()); // Log the exception
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log test as skipped
        test.get().log(Status.SKIP, MarkupHelper.createLabel("Test Skipped", ExtentColor.YELLOW));
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the report
        ExtentReportManager.getInstance().flush();
    }
}