package others;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumReader {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo driver
        WebDriver driver = new ChromeDriver();
        //Download driver
        WebDriverManager.chromedriver().setup();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        // Bước 1:  Enter Email //input[@placeholder="Enter email"]
        WebElement email = driver.findElement(By.xpath("//input[@placeholder=\"Enter email\"]"));
        email.sendKeys("devpro@gmail.com");
        Thread.sleep(5000);
        email.clear();
        email.sendKeys("ledacminh@gmail.com");
        Thread.sleep(3000);

        //Bước 2:  Email //input[@placeholder="Enter Password"]
        WebElement password = driver.findElement(By.xpath("//input[@placeholder=\"Enter Password\"]"));
        password.sendKeys("admin@123");
        Thread.sleep(3000);

        //Bước 3:  Email //input[@placeholder="Enter your company"]
        WebElement company = driver.findElement(By.xpath("//input[@placeholder=\"Enter your company\"]"));
        company.sendKeys("Ngân hàng BIDV");
        Thread.sleep(3000);

        //Bước 4:  Email //input[@placeholder="Enter your mobile number"]
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder=\"Enter your mobile number\"]"));
        phone.sendKeys("0966152432");
        Thread.sleep(3000);

        //Bước 6: click submit   //button[@value='Submit']
        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@value='Submit']"));
        buttonSubmit.click();
        Thread.sleep(5000);

        driver.close();

    }
}
