@regression
Feature: Noel Landing Page

  @noel
  Scenario Outline: Search For product
    Given The user is on the noel Landing page
    When The user enters <searchKeyword> in search input box
    And The user clicks show all results button
    Then Verify the <searchKeyword> product is displayed on search page
    And Open the first displayed product
    And Click on Add to cart button
    And Click on Go to cart button
    And set the quantity to <Quantity> for the 1st product in the cart
    Then Verify the cart quantity is <Quantity>

    Examples:
      | searchKeyword | Quantity |
      | Iphone        | 5        |



