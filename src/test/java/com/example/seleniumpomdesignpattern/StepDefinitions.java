package com.example.seleniumpomdesignpattern;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import com.example.seleniumpomdesignpattern.page.SimpleFormDemo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {

    public static final String INPUT_TEXT = "Text from Cucumber test";
    private SimpleFormDemo simpleFormDemo;

    @Given("I am on the Single Input Field exercise")
    public void i_am_on_the_single_input_field_exercise() {
        simpleFormDemo = new SimpleFormDemo(WebDriverProvider.setupWebDriver());
        simpleFormDemo.openBasePage();
        simpleFormDemo.navigateIntoInputFormsMenu();
        simpleFormDemo.navigateToSimpleFormDemo();
    }
    @When("I enter my message")
    public void i_enter_my_message() {
        simpleFormDemo.sendKeysIntoInputField(INPUT_TEXT);
    }

    @Then("I can see my message printed")
    public void i_can_see_my_message_printed() {
        Assertions.assertEquals(INPUT_TEXT, simpleFormDemo.getMessage());
        simpleFormDemo.quitWebDriver();
    }
}
