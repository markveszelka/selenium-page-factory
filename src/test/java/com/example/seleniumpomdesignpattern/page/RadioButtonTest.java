package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class RadioButtonTest {

    private RadioButton radioButton;

    public static Stream<Arguments> singleRadioTestCases() {
        return Stream.of(
                Arguments.of("Male"),
                Arguments.of("Female")
        );
    }

    public static Stream<Arguments> multipleRadioTestCases() {
        return Stream.of(
                Arguments.of(List.of("Female", "0 - 5")),
                Arguments.of(List.of("Male", "5 - 15")),
                Arguments.of(List.of("Female", "15 - 50"))
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
    void singleRadioButton(String radioElement) {
        // Arrange in setUp()
        // Act
        radioButton.selectRadioButtons();
        radioButton.clickSingleRadioButton(radioElement);
        // Assert
        String expected = String.format("Radio button '%s' is checked", radioElement);
        Assertions.assertEquals(expected, radioButton.getSingleValue());
    }

    @ParameterizedTest
    @MethodSource("multipleRadioTestCases")
    @DisplayName("Test the multiple radio buttons are checked or not")
    void multipleRadioButtons(List<String> radioButtons) {
        // Arrange in setUp()
        // Act
        radioButton.selectRadioButtons();
        radioButton.clickMultipleRadioButtons(radioButtons);
        // Assert
        String gender = radioButtons.get(0);
        String age = radioButtons.get(1);
        String expected = String.format("Sex : %s\n" +
                "Age group: %s", gender, age);
        String actual = radioButton.getMultipleValues();
        Assertions.assertEquals(expected, actual);
    }
}
