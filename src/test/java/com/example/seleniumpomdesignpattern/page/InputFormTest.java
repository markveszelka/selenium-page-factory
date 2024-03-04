package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputFormTest {

    private SimpleFormDemo simpleFormDemo;

    @BeforeEach
    void setUp() {
        simpleFormDemo = new SimpleFormDemo(WebDriverProvider.setupWebDriver());
        simpleFormDemo.openBasePage();
    }

    @AfterEach
    void tearDown() {
        simpleFormDemo.quitWebDriver();
    }

    @Test
    void navigateIntoInputFormsMenu() {
        // Act
        simpleFormDemo.navigateIntoInputFormsMenu();
        // Assert
        Assertions.assertTrue(simpleFormDemo.isDropDownOpen());
    }
}
