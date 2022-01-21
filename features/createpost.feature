Feature: Create post on account Page
  Background: Logged in to account
    Given A user is on the login page
    When A user inputs correct credentials on the login form
    Then the user will be redirect to the user's account page
  Scenario: Create a new post
    Given A user is on the account page
    When A user clicks new post button
    Then A user inputs post description and image