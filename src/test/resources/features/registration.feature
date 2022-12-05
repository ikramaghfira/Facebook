@regression
Feature: registration

  Scenario: user can register an account with valid credential
    Given user is on Facebook Registration page
    When user fill all fields with valid credential
    Then user should be navigated to input OTP code
