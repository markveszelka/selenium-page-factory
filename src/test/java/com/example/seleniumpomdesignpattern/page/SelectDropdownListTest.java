package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class SelectDropdownListTest {

    private static final String TEST_PAGE_URL = "https://web.archive.org/web/20180930221201/http://www.seleniumeasy.com/test/";
    private WebDriver driver;
    private SimpleFormDemo simpleFormDemo;

    @BeforeEach
    void setUp() {
        driver = WebDriverProvider.setupWebDriver();
        driver.get(TEST_PAGE_URL);
        // Arrange
        simpleFormDemo = new SimpleFormDemo(driver);
        simpleFormDemo.navigateIntoInputFormsMenu();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void selectCurrentDay() {
        // Arrange
        SelectDropdownList selectDropdownList = new SelectDropdownList(driver);
        // Act
        selectDropdownList.selectCurrentDay();
        // Assert
        String expected = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
        Assertions.assertEquals(expected, selectDropdownList.getSelected());
    }
}
