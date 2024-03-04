package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class SelectDropdownList extends InputForm {

    private final By dropDownMenu = By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[4]/a");
    private final By daySelect = By.id("select-demo");

    public SelectDropdownList(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectCurrentDay() {
        driver.findElement(dropDownMenu).click();
        Select daySelect = new Select(driver.findElement(this.daySelect));
        daySelect.selectByValue(getToday());
    }

    public String getToday() {
        LocalDate date = LocalDate.now();
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }

    public String getSelected() {
        Select daySelect = new Select(driver.findElement(this.daySelect));
        return daySelect.getFirstSelectedOption().getText();
    }
}
