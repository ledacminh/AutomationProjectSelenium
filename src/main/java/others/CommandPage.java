package others;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.util.List;

public class CommandPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--ignore-certificate-errors");

        ChromiumDriver driver = new ChromeDriver(options);
        driver.get("https://uitestingplayground.com/home");
        driver.manage().window().maximize();
        String tileHome = driver.getTitle();
        System.out.println("Title Home: " + tileHome);
        Thread.sleep(5000);

        //1. Click on Elements
        driver.findElement(By.xpath("//h3/a[contains(text(),'Dynamic ID')]")).click();
        Thread.sleep(3000);

        //2. Command Refresh
        driver.navigate().refresh();
        Thread.sleep(3000);

        //3. Command Back
        driver.navigate().back();
        Thread.sleep(3000);

        //4. Command Forward
        driver.navigate().forward();
        Thread.sleep(3000);

        //5. Command Get Current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Thread.sleep(3000);

        //6. Command Get Title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Thread.sleep(3000);

        //7. Command open tab new
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com/");
        Thread.sleep(5000);

        //7. Command open tab new
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/");
        Thread.sleep(5000);

        //7. Command open tab new
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://google.com");
        Thread.sleep(5000);

        //8. Command switch to tab
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        Thread.sleep(5000);

        List<String> listTab = driver.getWindowHandles().stream().toList();
        for (String s : listTab) {
            String titleTab = driver.switchTo().window(s).getTitle();
            if (!"Dynamic ID".equals(titleTab)) {
                System.out.println("Đã chuyển sang tab có title: " + titleTab);
                driver.close();
                Thread.sleep(3000);
            }
        }


        driver.quit();


    }

}
