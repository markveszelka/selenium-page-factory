package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

class SimpleFormDemoTest {

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
    void navigateToSimpleFormDemo() {
        // Act
        simpleFormDemo.navigateToSimpleFormDemo();
        // Assert
        String expected = "This would be your first example to start with Selenium.";
        Assertions.assertEquals(expected, simpleFormDemo.getPageHeading());
    }

    @Test
    void showMessageInInputField() {
        // Arrange
        simpleFormDemo.navigateToSimpleFormDemo();
        // Act
        simpleFormDemo.showMessageInInputField();
        // Assert
        String expected = "Hello World";
        Assertions.assertEquals(expected, simpleFormDemo.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"100, 300", "10, 90", "400, 600"})
    void getTotalOfTwoInputField(int num1, int num2) {
        // Arrange
        simpleFormDemo.navigateToSimpleFormDemo();
        // Act
        simpleFormDemo.getTotalOfTwoInputField(num1, num2);
        // Assert
        int expected = num1 + num2;
        Assertions.assertEquals(expected, Integer.parseInt(simpleFormDemo.getTotal()));
    }
}
