package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public abstract class InputForm extends BasePage {

    private final By OPEN_DROP_DOWN = By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[1]");
    private final By inputFormElement = By.xpath("//a[text()='Input Forms']");


    public InputForm(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateIntoInputFormsMenu() {
        driver.findElement(inputFormElement).click();
    }

    public boolean isDropDownOpen() {
        WebElement element = driver.findElement(OPEN_DROP_DOWN);
        String attribute = element.getAttribute("style");

        return Objects.equals(attribute, "display: list-item;");
    }
}
