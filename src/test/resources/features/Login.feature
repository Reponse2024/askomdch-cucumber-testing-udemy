@Login
@Regression
@Smoke
Feature: User Login
  In order to access my account
  As a registered user
  I want to login successfully

  Background:
    Given I am on the AskOmDch homepage
    When I click on the Account tab

  @ValidCredentials
  @Critical
  Scenario: Login with valid credentials
    And I enter "iduha26" and "Reponse@testing" in the login form
    And I click the Log in button
    Then I should see the account dashboard
    And I should see a success message
    And I should see a logout link

  @InvalidCredentials
  @Negative
  Scenario: Login with invalid credentials
    And I enter "notRegistered" and "wrongpassword" in the login form
    And I click the Log in button
    Then I should see an error message

  @EmptyFields
  @Negative
  Scenario: Login with empty fields
    And I click the Log in button
    Then I should see an error message