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
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Stream;

class RadioButtonTest {

    private static final String TEST_PAGE_URL = "https://web.archive.org/web/20180930221201/http://www.seleniumeasy.com/test/";
    private WebDriver driver;
    private SimpleFormDemo simpleFormDemo;

    public static Stream<Arguments> singleRadioTestCases() {
        return Stream.of(
                Arguments.of(RadioButton.MALE_1_ELEMENT),
                Arguments.of(RadioButton.FEMALE_1_ELEMENT)
        );
    }

    public static Stream<Arguments> multipleRadioTestCases() {
        return Stream.of(
                Arguments.of(List.of(RadioButton.MALE_2_ELEMENT, RadioButton.FIFTEEN_TO_FIFTY)),
                Arguments.of(List.of(RadioButton.FEMALE_2_ELEMENT, RadioButton.ZERO_TO_FIVE)),
                Arguments.of(List.of(RadioButton.MALE_2_ELEMENT, RadioButton.FIVE_TO_FIFTEEN))
        );
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
    @MethodSource("singleRadioTestCases")
    @DisplayName("Test the single radio button is checked or not")
    void singleRadioButton(By radioElement) {
        // Arrange
        RadioButton radioButton = new RadioButton(driver);
        // Act
        radioButton.selectRadioButtons();
        radioButton.singleRadioButton(radioElement);
        // Assert
        String expected = String.format(
                "Radio button '%s' is checked",
                driver.findElement(radioElement).getAttribute("value"));
        Assertions.assertEquals(expected, radioButton.getSingleValue());
    }

    @ParameterizedTest
    @MethodSource("multipleRadioTestCases")
    @DisplayName("Test the multiple radio buttons are checked or not")
    void multipleRadioButtons(List<By> radioButtons) {
        // Arrange
        RadioButton radioButton = new RadioButton(driver);
        // Act
        radioButton.selectRadioButtons();
        radioButton.multipleRadioButtons(radioButtons);
        // Assert
        String gender = driver.findElement(radioButtons.get(0)).getAttribute("value");
        String age = driver.findElement(radioButtons.get(1)).getAttribute("value");
        String expected = String.format("Sex : %s\n" +
                "Age group: %s", gender, age);
        String actual = radioButton.getMultipleValues();
        Assertions.assertEquals(expected, actual);
    }
}
