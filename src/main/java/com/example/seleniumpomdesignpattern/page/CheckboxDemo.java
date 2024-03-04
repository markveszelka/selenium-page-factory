package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxDemo extends InputForm {

    @FindBy(xpath = "(//a[@href='./basic-checkbox-demo.html'])[2]")
    private WebElement checkBoxMenu;
    @FindBy(id = "isAgeSelected")
    private WebElement ageCheckBox;
    @FindBy(xpath = "//input[@class='cb1-element']")
    private List<WebElement> optionCheckBox;

    public CheckboxDemo(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkBoxValidation(boolean checkboxState, List<Boolean> checkboxStates) {
        checkBoxMenu.click();
        clickSingleCheckBox(checkboxState);
        clickMultipleCheckBoxes(checkboxStates);
    }

    private void clickMultipleCheckBoxes(List<Boolean> checkboxStates) {
        List<WebElement> optionCheckBoxElements = optionCheckBox;
        for (int i = 0; i < optionCheckBoxElements.size(); i++) {
            if (checkboxStates.get(i)) {
                optionCheckBoxElements.get(i).click();
            }
        }
    }

    private void clickSingleCheckBox(boolean checkboxState) {
        if (checkboxState) {
            ageCheckBox.click();
        }
    }

    public boolean isSingleCheckboxChecked() {
        return ageCheckBox.isSelected();
    }

    public boolean isMultipleCheckboxChecked(int index) {
        List<WebElement> elements = optionCheckBox;
        return elements.get(index).isSelected();
    }
}
