Feature: OrangeHRM User Login
  As a user
  I want to login to OrangeHRM application
  So that I can access my dashboard

  Background:
    Given user navigates to OrangeHRM login page

  Scenario: Successful login with valid credentials
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks login button
    Then user should see the dashboard page
    And user should see the page title "OrangeHRM"

  Scenario: Login and verify current URL
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks login button
    Then user should be redirected to dashboard URL

 @smoke
  Scenario: Verify login page is displayed
    Then login page should be displayed
    When user enters username "Admin"
    And user enters password "admin1234"
    And user clicks login button
    Then user should not be redirected to dashboard URL