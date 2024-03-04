package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CheckboxDemoTest {

    private CheckboxDemo checkboxDemo;

    public static Stream<Arguments> checkboxValidationTestCases() {
        return Stream.of(
                Arguments.of(true, List.of(true, true, true, true)),
                Arguments.of(false, List.of(false, false, false, false)),
                Arguments.of(true, List.of(false, true, false, true)));
    }

    @BeforeEach
    void setUp() {
        checkboxDemo = new CheckboxDemo(WebDriverProvider.setupWebDriver());
        checkboxDemo.openBasePage();
        checkboxDemo.navigateIntoInputFormsMenu();
    }

    @AfterEach
    void tearDown() {
        checkboxDemo.quitWebDriver();
    }

    @ParameterizedTest
    @MethodSource("checkboxValidationTestCases")
    void checkBoxValidation(boolean singleCheckBoxValue, List<Boolean> multipleCheckboxValues) {
        // Act
        checkboxDemo.checkBoxValidation(singleCheckBoxValue, multipleCheckboxValues);
        // Assert
        Assertions.assertEquals(singleCheckBoxValue, checkboxDemo.isSingleCheckboxChecked());
        for (int i = 0; i < multipleCheckboxValues.size(); i++) {
            Assertions.assertEquals(multipleCheckboxValues.get(i), checkboxDemo.isMultipleCheckboxChecked(i));
        }
    }
}
