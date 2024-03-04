package com.example.seleniumpomdesignpattern.page;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

class SelectDropdownListTest {

    private SelectDropdownList selectDropdownList;

    @BeforeEach
    void setUp() {
        selectDropdownList = new SelectDropdownList(WebDriverProvider.setupWebDriver());
        selectDropdownList.openBasePage();
        selectDropdownList.navigateIntoInputFormsMenu();
    }

    @AfterEach
    void tearDown() {
        selectDropdownList.quitWebDriver();
    }

    @Test
    void selectCurrentDay() {
        // Act
        selectDropdownList.selectCurrentDay();
        // Assert
        String expected = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
        Assertions.assertEquals(expected, selectDropdownList.getSelected());
    }
}
