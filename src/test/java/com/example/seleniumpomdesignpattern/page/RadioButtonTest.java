package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Stream;

class RadioButtonTest {

    private RadioButton radioButton;

    public static Stream<Arguments> singleRadioTestCases() {
        return Stream.of(
                Arguments.of(RadioButton.MALE_1),
                Arguments.of(RadioButton.FEMALE_1)
        );
    }

    public static Stream<Arguments> multipleRadioTestCases() {
        return Stream.of(
                Arguments.of(List.of(RadioButton.MALE_2, RadioButton.FIFTEEN_TO_FIFTY)),
                Arguments.of(List.of(RadioButton.FEMALE_2, RadioButton.ZERO_TO_FIVE)),
                Arguments.of(List.of(RadioButton.MALE_2, RadioButton.FIVE_TO_FIFTEEN))
        );
    }

    @BeforeEach
    void setUp() {
        radioButton = new RadioButton(WebDriverProvider.setupWebDriver());
        radioButton.openBasePage();
        radioButton.navigateIntoInputFormsMenu();
    }

    @AfterEach
    void tearDown() {
        radioButton.quitWebDriver();
    }

    @ParameterizedTest
    @MethodSource("singleRadioTestCases")
    @DisplayName("Test the single radio button is checked or not")
    void singleRadioButton(By radioElement) {
        // Act
        radioButton.selectRadioButtons();
        radioButton.singleRadioButton(radioElement);
        // Assert
        String expected = String.format(
                "Radio button '%s' is checked",
                radioButton.getDriver().findElement(radioElement).getAttribute("value"));
        Assertions.assertEquals(expected, radioButton.getSingleValue());
    }

    @ParameterizedTest
    @MethodSource("multipleRadioTestCases")
    @DisplayName("Test the multiple radio buttons are checked or not")
    void multipleRadioButtons(List<By> radioButtons) {
        // Act
        radioButton.selectRadioButtons();
        radioButton.multipleRadioButtons(radioButtons);
        // Assert
        String gender = radioButton.getDriver().findElement(radioButtons.get(0)).getAttribute("value");
        String age = radioButton.getDriver().findElement(radioButtons.get(1)).getAttribute("value");
        String expected = String.format("Sex : %s\n" +
                "Age group: %s", gender, age);
        String actual = radioButton.getMultipleValues();
        Assertions.assertEquals(expected, actual);
    }
}
