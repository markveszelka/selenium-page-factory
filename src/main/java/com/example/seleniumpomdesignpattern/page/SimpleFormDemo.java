package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleFormDemo extends InputForm {

    private final By simpleFormDemoElement = By.xpath("(//a[text()='All Examples']/following::a[text()='Simple Form Demo'])[1]");
    private final By pageHeadingElement = By.xpath("//h3[text()='This would be your first example to start with Selenium.']");
    private final By messageInputFieldElement = By.id("user-message");
    private final By showMessageButtonElement = By.xpath("//button[text()='Show Message']");
    private final By displayMessageElement = By.id("display");
    private final By sumOneElement = By.id("sum1");
    private final By sumTwoElement = By.id("sum2");
    private final By getTotalButtonElement = By.xpath("//button[text()='Get Total']");
    private final By totalValueElement = By.id("displayvalue");

    public SimpleFormDemo(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToSimpleFormDemo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(simpleFormDemoElement)).click();
    }

    public void showMessageInInputField() {
        driver.findElement(messageInputFieldElement).sendKeys("Hello World");
        driver.findElement(showMessageButtonElement).click();
    }

    public void getTotalOfTwoInputField(int value1, int value2) {
        driver.findElement(sumOneElement).sendKeys(String.valueOf(value1));
        driver.findElement(sumTwoElement).sendKeys(String.valueOf(value2));
        driver.findElement(getTotalButtonElement).click();
    }

    public String getPageHeading() {
        return driver.findElement(pageHeadingElement).getText();
    }

    public String getMessage() {
        return driver.findElement(displayMessageElement).getText();
    }

    public String getTotal() {
        return driver.findElement(totalValueElement).getText();
    }
}
