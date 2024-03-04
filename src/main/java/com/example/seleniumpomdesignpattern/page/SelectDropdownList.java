package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class SelectDropdownList extends InputForm {

    // TODO: Refactor this XPath
    @FindBy(xpath = "//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[4]/a")
    private WebElement dropDownMenu;
    @FindBy(id = "select-demo")
    private WebElement daySelect;

    public SelectDropdownList(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectCurrentDay() {
        dropDownMenu.click();
        Select daySelect = new Select(this.daySelect);
        daySelect.selectByValue(getToday());
    }

    public String getToday() {
        LocalDate date = LocalDate.now();
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    public String getSelected() {
        Select daySelect = new Select(this.daySelect);
        return daySelect.getFirstSelectedOption().getText();
    }
}
