package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class InputForm extends BasePage {

    private final By inputFormElement = By.xpath("//a[text()='Input Forms']");

    public InputForm(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateIntoInputFormsMenu() {
        driver.findElement(inputFormElement).click();
    }
}
