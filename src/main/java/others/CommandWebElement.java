package others;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandWebElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--ignore-certificate-errors");

        ChromiumDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //1. Click on Elements   //h5[text()='Elements']

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h5[text()='Elements']"))));
        driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        Thread.sleep(3000);


        WebElement textbox = driver.findElement(By.xpath("//li//span[contains(text(),'Text Box')]"));
        textbox.click();
        Thread.sleep(3000);

        WebElement email = driver.findElement(By.xpath("//input[@placeholder=\"name@example.com\"]"));
        email.sendKeys("abcdef");

        String borderBeforeClickSubmit = email.getCssValue("border");
        System.out.println("colorBefore = " + borderBeforeClickSubmit);
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver; // Ép kiểu sang JS
        js.executeScript("window.scrollBy(0,500)"); // Cuộn xuống 500px

        WebElement buttonSubmit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        buttonSubmit.click();
        Thread.sleep(3000);


        String borderAfterClickSubmit = email.getCssValue("border");
        System.out.println("colorAfter = " + borderAfterClickSubmit);
        String colorHex = Color.fromString(borderAfterClickSubmit.substring(10)).asHex();
        System.out.println("colorHex = " + colorHex);

        WebElement buttonExpandHome = driver.findElement(By.xpath("//span[contains(text(),'Home')]/parent::label[@for='tree-node-home']/preceding-sibling::button"));


        driver.quit();


    }

}
