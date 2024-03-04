package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class RadioButton extends InputForm {

    @FindBy(xpath = "//input[@value='Male' and @name='optradio']")
    private WebElement male1;
    @FindBy(xpath = "//input[@value='Female' and @name='optradio']")
    private WebElement female1;
    @FindBy(xpath = "//input[@value='Male' and @name='gender']")
    private WebElement male2;
    @FindBy(xpath = "//input[@value='Female' and @name='gender']")
    private WebElement female2;
    @FindBy(xpath = "//input[@value='0 - 5']")
    private WebElement zeroToFive;
    @FindBy(xpath = "//input[@value='5 - 15']")
    private WebElement fiveToFifteen;
    @FindBy(xpath = "//input[@value='15 - 50']")
    private WebElement fifteenToFifty;
    // TODO: Refactor this XPath
    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")
    private WebElement getValuesButton;
    // TODO: Refactor this XPath
    @FindBy(xpath = "//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[3]/a")
    private WebElement radioButtonsMenu;
    @FindBy(id = "buttoncheck")
    private WebElement getValueButton;
    @FindBy(xpath = "//p[@class='radiobutton']")
    private WebElement getSingleValue;
    @FindBy(xpath = "//p[@class='groupradiobutton']")
    private WebElement getMultipleValues;

    public RadioButton(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectRadioButtons() {
        radioButtonsMenu.click();
        getValueButton.click();
    }

    public void clickSingleRadioButton(String selectedValue) {
        List<WebElement> radioElements = List.of(male1, female1);

        for (WebElement radioElement : radioElements) {
            if (Objects.equals(radioElement.getAttribute("value"), selectedValue)) {
                radioElement.click();
                break;
            }
        }

        getValueButton.click();
    }

    public void clickMultipleRadioButtons(List<String> selectedValues) {
        List<WebElement> radioElements = List.of(male2, female2, zeroToFive, fiveToFifteen, fifteenToFifty);

        for (String radioButton : selectedValues) {
            for (WebElement radioElement : radioElements) {
                if (radioButton.equals(radioElement.getAttribute("value"))) {
                    radioElement.click();
                }
            }
        }

        getValuesButton.click();
    }

    public String getSingleValue() {
        return getSingleValue.getText();
    }

    public String getMultipleValues() {
        return getMultipleValues.getText();
    }
}
