package com.example.seleniumpomdesignpattern.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    private static final String TEST_PAGE_URL = "https://web.archive.org/web/20180930221201/http://www.seleniumeasy.com/test/";
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openBasePage() {
        driver.get(TEST_PAGE_URL);
    }

    public void quitWebDriver() {
        driver.quit();
    }
}
