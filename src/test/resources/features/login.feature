#Feature: User Login
#  To allow users to securely log in, ensure the system verifies their credentials appropriately.
#
#  Background:
#    Given I am on the login page
#
#  @positive
#  Scenario: Login with valid credentials
#    Given I have a registered user
#    When I login with valid credentials
#    Then I should be logged in successfully
#
#  @negative
#  Scenario Outline: Fail to login with invalid credentials
#    When I login with email "<email>" and password "<password>"
#    Then I should see an error message "<error>"
#
#    Examples:
#      | email                     | password       | error                                                                 |
#      | invalid@test.com          | wrongPass      | The account sign-in was incorrect or your account is disabled temporarily. |
#      |                           | P@ssw0rd123!   | This is a required field.                                             |
#      | valid@test.com            |                | This is a required field.                                             |
#      | invalid-email.com         | P@ssw0rd123!   | Invalid email address format.                                         |
#      | locked@test.com           | P@ssw0rd123!   | This account is locked. Please contact customer support.              |
#
#  @positive
#  Scenario: Session persistence after browser restart
#    Given I am logged in
#    When I close and reopen the browser
#    And I navigate to the account page
#    Then I should still be logged in