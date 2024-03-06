package com.example.seleniumpomdesignpattern;

import com.example.seleniumpomdesignpattern.config.WebDriverProvider;
import com.example.seleniumpomdesignpattern.page.SimpleFormDemo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {

    private SimpleFormDemo simpleFormDemo;

    @Given("I am on the Single Input Field exercise")
    public void i_am_on_the_single_input_field_exercise() {
        simpleFormDemo = new SimpleFormDemo(WebDriverProvider.setupWebDriver());
        simpleFormDemo.openBasePage();
        simpleFormDemo.navigateIntoInputFormsMenu();
        simpleFormDemo.navigateToSimpleFormDemo();
    }
    @When("I enter my {string}")
    public void i_enter_my_message(String message) {
        simpleFormDemo.sendKeysIntoInputField(message);
    }

    @Then("I can see my {string} printed")
    public void i_can_see_my_message_printed(String message) {
        Assertions.assertEquals(message, simpleFormDemo.getMessage());
        simpleFormDemo.quitWebDriver();
    }
}
