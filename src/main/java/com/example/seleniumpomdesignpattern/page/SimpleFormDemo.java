package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleFormDemo extends InputForm {

    private final By simpleFormDemo = By.xpath("(//a[text()='All Examples']/following::a[text()='Simple Form Demo'])[1]");
    private final By pageHeading = By.xpath("//h3[text()='This would be your first example to start with Selenium.']");
    private final By messageInputField = By.id("user-message");
    private final By showMessageButton = By.xpath("//button[text()='Show Message']");
    private final By displayMessage = By.id("display");
    private final By sumOne = By.id("sum1");
    private final By sumTwo = By.id("sum2");
    private final By getTotalButton = By.xpath("//button[text()='Get Total']");
    private final By totalValue = By.id("displayvalue");

    public SimpleFormDemo(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToSimpleFormDemo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(simpleFormDemo)).click();
    }

    public void showMessageInInputField() {
        driver.findElement(messageInputField).sendKeys("Hello World");
        driver.findElement(showMessageButton).click();
    }

    public void getTotalOfTwoInputField(int value1, int value2) {
        driver.findElement(sumOne).sendKeys(String.valueOf(value1));
        driver.findElement(sumTwo).sendKeys(String.valueOf(value2));
        driver.findElement(getTotalButton).click();
    }

    public String getPageHeading() {
        return driver.findElement(pageHeading).getText();
    }

    public String getMessage() {
        return driver.findElement(displayMessage).getText();
    }

    public String getTotal() {
        return driver.findElement(totalValue).getText();
    }
}
