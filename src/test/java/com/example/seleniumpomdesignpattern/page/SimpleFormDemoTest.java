package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SimpleFormDemoTest {

    private SimpleFormDemo simpleFormDemo;

    @BeforeEach
    void setUp() {
        simpleFormDemo = new SimpleFormDemo(WebDriverProvider.setupWebDriver());
        simpleFormDemo.openBasePage();
        simpleFormDemo.navigateIntoInputFormsMenu();
    }

    @AfterEach
    void tearDown() {
        simpleFormDemo.quitWebDriver();
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
