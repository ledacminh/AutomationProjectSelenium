package testcases;


import actions.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import report.ExtentTestManager;

public class LoginTestCase extends BaseTest {

    @Test
    public void openDemoQA() {
       WebDriver  driver = getBrowserDriver("CHROME", "https://demoqa.com");
        ExtentTestManager.getTest().log(Status.INFO, "Open DemoQA");

        // Ví dụ cố tình verify đơn giản
        driver.findElement(By.xpath("//div[@dfdfdg='43444']")).click();

    }

}
