Feature: User Signup
  @positive
  Scenario: Successful registration with valid details
    Given I am on the signup page
    When I enter valid registration details
    Then I should be redirected to my account page
    When I log out
    Then I should be on the login page