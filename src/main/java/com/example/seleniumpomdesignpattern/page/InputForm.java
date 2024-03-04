package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public abstract class InputForm extends BasePage {

    // TODO: Refactor this XPath
    @FindBy(xpath = "//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[1]")
    private WebElement openDropDown;
    @FindBy(xpath = "//a[text()='Input Forms']")
    private WebElement inputForm;

    public InputForm(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateIntoInputFormsMenu() {
        inputForm.click();
    }

    public boolean isDropDownOpen() {
        String attribute = openDropDown.getAttribute("style");
        return Objects.equals(attribute, "display: list-item;");
    }


}
