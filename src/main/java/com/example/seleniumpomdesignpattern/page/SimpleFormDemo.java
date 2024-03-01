package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleFormDemo extends InputForm {

    private final By simpleFormDemoElement = By.xpath("(//a[text()='All Examples']/following::a[text()='Simple Form Demo'])[1]");
    private final By pageHeadingElement = By.xpath("//h3");

    public SimpleFormDemo(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToSimpleFormDemo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(simpleFormDemoElement)).click();
    }

    public void showMessageInInputField() {

    }

    public void getTotalOfTwoInputField() {

    }

    public String getPageHeading() {
        return driver.findElement(pageHeadingElement).getText();
    }
}
