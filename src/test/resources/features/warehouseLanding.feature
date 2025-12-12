@regression
Feature: Warehouse Landing Page

  @warehouse
  Scenario Outline: Search For product
    Given The user is on the warehouse Landing page
    When The user enters <searchKeyword> in search input box
    And The user clicks show all results button
    Then Verify the <searchKeyword> product is displayed on search page
    And Open the first displayed product







