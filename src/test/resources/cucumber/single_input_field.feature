Feature: Enter a message
  As a user
  I want to see my entered message
  So that I can see my message

  Scenario: User enters a message and gets its value
    Given I am on the Single Input Field exercise
    When I enter my message
    Then I can see my message printed
