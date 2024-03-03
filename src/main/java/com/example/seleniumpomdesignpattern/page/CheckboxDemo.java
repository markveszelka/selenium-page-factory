package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxDemo extends InputForm {

    private final By checkBoxMenuElement = By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[2]/a");
    private final By ageCheckBoxElement = By.id("isAgeSelected");
    private final By optionCheckBoxElement = By.xpath("//input[@class='cb1-element']");

    public CheckboxDemo(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkBoxValidation(boolean checkboxState, List<Boolean> checkboxStates) {
        driver.findElement(checkBoxMenuElement).click();
        clickSingleCheckBox(checkboxState);
        clickMultipleCheckBoxes(checkboxStates);
    }

    private void clickMultipleCheckBoxes(List<Boolean> checkboxStates) {
        List<WebElement> optionCheckBoxElements = driver.findElements(optionCheckBoxElement);
        for (int i = 0; i < optionCheckBoxElements.size(); i++) {
            if (checkboxStates.get(i)) {
                optionCheckBoxElements.get(i).click();
            }
        }
    }

    private void clickSingleCheckBox(boolean checkboxState) {
        if (checkboxState) {
            driver.findElement(ageCheckBoxElement).click();
        }
    }

    public boolean isSingleCheckboxChecked() {
        return driver.findElement(ageCheckBoxElement).isSelected();
    }

    public boolean isMultipleCheckboxChecked(int index) {
        List<WebElement> elements = driver.findElements(optionCheckBoxElement);
        return elements.get(index).isSelected();
    }
}
