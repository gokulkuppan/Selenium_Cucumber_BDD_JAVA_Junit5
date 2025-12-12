@regression
Feature: Login

  @smoke @login1 @wareHouse
  Scenario: Search for product
    Given the user is on the wareHouse Landing page
    When the user enters "Laptop" in search input box
    Then User clicks on "Lenovo Duet 11 inch MediaTek 4GB RAM 128GB eMMC Touchscreen Chromebook" in the sarch result page


