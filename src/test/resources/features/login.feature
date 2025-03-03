Feature: User Login

  @negative
  Scenario: Verify error message for incorrect login credentials
    Given I am on the login page
    When I enter incorrect login credentials
    Then I should see an error message "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."

  @positive
  Scenario: Verify user can successfully log in with registered credentials
    Given I am on the login page
    When I enter registered email and password
    Then  I should be redirected to my account page after login
