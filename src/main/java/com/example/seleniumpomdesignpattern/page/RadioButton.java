package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButton extends InputForm {

    public final static By RADIO_BUTTONS_MENU_ELEMENT = By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[3]/a");
    public final static By MALE_1_ELEMENT = By.xpath("//input[@value='Male' and @name='optradio']");
    public final static By FEMALE_1_ELEMENT = By.xpath("//input[@value='Female' and @name='optradio']");
    public final static By GET_VALUE_BUTTON = By.id("buttoncheck");
    public final static By GET_SINGLE_VALUE = By.xpath("//p[@class='radiobutton']");
    public final static By MALE_2_ELEMENT = By.xpath("//input[@value='Male' and @name='gender']");
    public final static By FEMALE_2_ELEMENT = By.xpath("//input[@value='Female' and @name='gender']");
    public final static By ZERO_TO_FIVE = By.xpath("//input[@value='0 - 5']");
    public final static By FIVE_TO_FIFTEEN = By.xpath("//input[@value='5 - 15']");
    public final static By FIFTEEN_TO_FIFTY = By.xpath("//input[@value='15 - 50']");
    public final static By GET_VALUES_BUTTON = By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button");
    public final static By GET_MULTIPLE_VALUES = By.xpath("//p[@class='groupradiobutton']");

    public RadioButton(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectRadioButtons() {
        driver.findElement(RADIO_BUTTONS_MENU_ELEMENT).click();
        driver.findElement(GET_VALUE_BUTTON).click();
    }

    public void singleRadioButton(By genderRadioButton) {
        driver.findElement(genderRadioButton).click();
        driver.findElement(GET_VALUE_BUTTON).click();
    }

    public void multipleRadioButtons(List<By> radioButtons) {
        for (By radioButton : radioButtons) {
            driver.findElement(radioButton).click();
        }
        driver.findElement(GET_VALUES_BUTTON).click();
    }

    public String getSingleValue() {
        return driver.findElement(GET_SINGLE_VALUE).getText();
    }

    public String getMultipleValues() {
        return driver.findElement(GET_MULTIPLE_VALUES).getText();
    }
}
