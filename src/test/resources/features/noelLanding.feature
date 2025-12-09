@regression
Feature: Noel Landing Page

  @noel
  Scenario: Search For product
    Given The user is on the noel Landing page
    When The user enters Iphone in search input box
    And The user clicks show all results button
    Then Verify the Iphone product is displayed on search page


