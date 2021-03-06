Feature: Login Page
  Scenario: Logging in with incorrect credentials on login page will display error message
    Given A user is on the login page
    When A user inputs incorrect credentials on the login form
    Then invalid username or password will be displayed to the user
  Scenario: Logging in with correct credentials on login page will redirect to the user's account page
    Given A user is on the login page
    When A user inputs correct credentials on the login form
    Then the user will be redirect to the user's account page
  Scenario: Clicking the Register Button will take user to the registration page
    Given A user is on the login page
    When A user clicks the register button
    Then user will be redirected to the register page
  Scenario: Clicking the Forgot Password Link will take user to the forgot password page
    Given A user is on the login page
    When A user clicks the forgot password link
    Then user will be redirected to the forgot password page