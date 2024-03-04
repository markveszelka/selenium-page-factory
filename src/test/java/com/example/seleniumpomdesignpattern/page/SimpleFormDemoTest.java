package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        // Arrange in setUp()
        // Act
        simpleFormDemo.navigateToSimpleFormDemo();
        // Assert
        String expected = "This would be your first example to start with Selenium.";
        Assertions.assertEquals(expected, simpleFormDemo.getPageHeading());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello World", "Test 1 Test 2", "Mark is my name"})
    void showMessageInInputField(String parameter) {
        // Arrange
        simpleFormDemo.navigateToSimpleFormDemo();
        // Act
        simpleFormDemo.sendKeysIntoInputField(parameter);
        // Assert
        Assertions.assertEquals(parameter, simpleFormDemo.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"100, 300, 400", "10, 90, 100", "400, 600, 1000", "2, 8, 10", "17, 13, 30"})
    void getTotalOfTwoInputField(int num1, int num2, int expected) {
        // Arrange
        simpleFormDemo.navigateToSimpleFormDemo();
        // Act
        simpleFormDemo.getTotalValueOfTwoInputFields(num1, num2);
        // Assert
        Assertions.assertEquals(expected, Integer.parseInt(simpleFormDemo.getTotal()));
    }
}
