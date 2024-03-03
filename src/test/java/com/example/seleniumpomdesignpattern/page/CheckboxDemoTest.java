package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Stream;

class CheckboxDemoTest {

    private static final String TEST_PAGE_URL = "https://web.archive.org/web/20180930221201/http://www.seleniumeasy.com/test/";
    private WebDriver driver;
    private SimpleFormDemo simpleFormDemo;

    public static Stream<Arguments> checkboxValidationTestCases() {
        return Stream.of(
                Arguments.of(true, List.of(true, true, true, true)),
                Arguments.of(false, List.of(false, false, false, false)),
                Arguments.of(true, List.of(false, true, false, true)));
    }

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

    @ParameterizedTest
    @MethodSource("checkboxValidationTestCases")
    void checkBoxValidation(boolean singleCheckBoxValue, List<Boolean> multipleCheckboxValues) {
        // Arrange
        CheckboxDemo checkboxDemo = new CheckboxDemo(driver);
        // Act
        checkboxDemo.checkBoxValidation(singleCheckBoxValue, multipleCheckboxValues);
        // Assert
        Assertions.assertEquals(singleCheckBoxValue, checkboxDemo.isSingleCheckboxChecked());
        for (int i = 0; i < multipleCheckboxValues.size(); i++) {
            Assertions.assertEquals(multipleCheckboxValues.get(i), checkboxDemo.isMultipleCheckboxChecked(i));
        }
    }
}
