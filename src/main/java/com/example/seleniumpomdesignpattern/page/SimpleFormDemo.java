package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleFormDemo extends InputForm {

    @FindBy(xpath = "(//a[text()='All Examples']/following::a[text()='Simple Form Demo'])[1]")
    private WebElement simpleFormDemo;
    @FindBy(xpath = "//h3[text()='This would be your first example to start with Selenium.']")
    private WebElement pageHeading;
    @FindBy(xpath = "//button[text()='Show Message']")
    private WebElement showMessageButton;
    @FindBy(xpath = "//button[text()='Get Total']")
    private WebElement getTotalButton;
    @FindBy(id = "user-message")
    private WebElement messageInputField;
    @FindBy(id = "display")
    private WebElement displayMessage;
    @FindBy(id = "sum1")
    private WebElement sumOne;
    @FindBy(id = "sum2")
    private WebElement sumTwo;
    @FindBy(id = "displayvalue")
    private WebElement totalValue;

    public SimpleFormDemo(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToSimpleFormDemo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(simpleFormDemo)).click();
    }

    public void sendKeysIntoInputField(String inputText) {
        messageInputField.sendKeys(inputText);
        showMessageButton.click();
    }

    public void getTotalValueOfTwoInputFields(int value1, int value2) {
        sumOne.sendKeys(String.valueOf(value1));
        sumTwo.sendKeys(String.valueOf(value2));
        getTotalButton.click();
    }

    public String getPageHeading() {
        return pageHeading.getText();
    }

    public String getMessage() {
        return displayMessage.getText();
    }

    public String getTotal() {
        return totalValue.getText();
    }
}
