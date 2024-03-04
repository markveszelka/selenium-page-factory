package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class InputFormTest {

    private static final String TEST_PAGE_URL = "https://web.archive.org/web/20180930221201/http://www.seleniumeasy.com/test/";
    private WebDriver driver;
    private SimpleFormDemo simpleFormDemo;

    @BeforeEach
    void setUp() {
        driver = WebDriverProvider.setupWebDriver();
        driver.get(TEST_PAGE_URL);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void navigateIntoInputFormsMenu() {
        // Arrange
        simpleFormDemo = new SimpleFormDemo(driver);
        // Act
        simpleFormDemo.navigateIntoInputFormsMenu();
        // Assert
        Assertions.assertTrue(simpleFormDemo.isDropDownOpen());
    }
}
