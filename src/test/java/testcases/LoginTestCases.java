package testcases;


import com.aventstack.extentreports.Status;
import common.Log;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import report.ExtentTestManager;

public class LoginTestCases extends base.BaseTest {

    @Test
    public void openDemoQA() {
        ExtentTestManager.getTest().log(Status.INFO, "Open DemoQA");
        driver.get("https://demoqa.com");

        // Ví dụ cố tình verify đơn giản
        boolean hasBanner = driver.findElements(By.cssSelector(".home-banner")).size() > 0;
        ExtentTestManager.getTest().info("Home banner present? " + hasBanner);
        assert hasBanner : "Home banner is missing!";
    }

}
