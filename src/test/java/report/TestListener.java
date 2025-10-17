// src/test/java/report/TestListener.java
package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {
    private static ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName())
                .assignCategory(result.getTestContext().getSuite().getName());
        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
        ExtentTestManager.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        test.fail(result.getThrowable());

        Object driverObj = result.getTestContext().getAttribute("driver");
        if (driverObj instanceof WebDriver) {
            String path = takeScreenshot((WebDriver) driverObj, result.getMethod().getMethodName());
            test.fail("Screenshot on failure",
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }
        ExtentTestManager.remove();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "Test skipped: " + result.getSkipCausedBy().toString());
        ExtentTestManager.remove();
    }

    private String takeScreenshot(WebDriver driver, String name) {
        try {
            String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String shotsDir = "target/extent/screenshots";
            new File(shotsDir).mkdirs();
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dest = Paths.get(shotsDir, name + "_" + ts + ".png").toString();
            FileUtils.copyFile(src, new File(dest));
            return dest;
        } catch (Exception e) {
            return null;
        }
    }
}
