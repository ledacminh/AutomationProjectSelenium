package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {
    private WebElement element;
    private WebDriverWait wait;
    private Actions actions;



    //1. Command element
    //getXpath
    public By getXpath(String xpath) {
        return By.xpath(xpath);

    }

    //getDynamicXpath
    public By getDynamicXpath(String xpath, String... params) {
        return By.xpath(String.format(xpath, (Object) params));
    }

    //getElement
    public WebElement getElement(WebDriver driver, String xpath) {
        element = driver.findElement(getXpath(xpath));
        return element;
    }

    //getDynamicElement
    public WebElement getDynamicElement(WebDriver driver, String xpath, String... params) {
        element = driver.findElement(getDynamicXpath(xpath, params));
        return element;
    }

    //ClickOnElement
    public void clickOnElement(WebDriver driver, String xpath) {
        waitForElementIsClickable(driver, xpath);
        getElement(driver, xpath).click();
    }

    //ClickOnElement
    public void clearText(WebDriver driver, String xpath, String... params) {
        waitForElementIsClickable(driver, xpath, params);
        getDynamicElement(driver, xpath, params).click();
    }

    //ClickOnElement
    public void clearText(WebDriver driver, String xpath) {
        waitForElementVisible(driver, xpath);
        getElement(driver, xpath).clear();
    }

    //ClickOnElement
    public void clickOnElement(WebDriver driver, String xpath, String... params) {
        waitForElementVisible(driver, xpath, params);
        getDynamicElement(driver, xpath, params).clear();
    }


    public void waitForElementIsClickable(WebDriver driver, String xpath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds());
        wait.until(ExpectedConditions.elementToBeClickable(getElement(driver, xpath)));
    }

    public void waitForElementIsClickable(WebDriver driver, String xpath, String... params) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(getDynamicElement(driver, xpath, params)));
    }

    public void waitForElementVisible(WebDriver driver, String xpath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(getElement(driver, xpath)));
    }

    public void waitForElementVisible(WebDriver driver, String xpath, String... params) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(getDynamicElement(driver, xpath, params)));
    }




    //Command Page

}
