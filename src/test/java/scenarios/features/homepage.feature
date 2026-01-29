@home
Feature: Home Page Functionality

  Background:
    Given user launches the application
#    And user taps on the Account in the footer
#    When user clicks the Login button
    When user clicks the Menu button for Login
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status

  @sanity
  Scenario: Verify the Home Page Functionality
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And User select a product from wishlist page
    And User validate that it navigates to the PDP

  @sanity
  Scenario: Verify the Product Listing Page Functionality
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    And User remove a product to the wishlist from PLP
    And User validate that product removed from wishlist
    And User adds a product to the wishlist from PLP
    And User validate that it navigates to the PDP

  @saanity
  Scenario: Verify the Sort Functionality
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then User clicks on the sort option
    And User selects a sort option as price low to high
    And User validate that product sorted product is displayed
    Then User clicks on the sort option
    And User selects a sort option as price high to low
    And User validate that product sorted product is displayed

  @saanity
  Scenario: Verify the Filter Functionality
#    When user selects a makeup category from home page
#    And user clicks the sub category from makeup page
    And User clicks on the filter option
    And User select the category as makeup
    And User selects the brands as life
    And User validate that products are displayed as per filter
    Then User clicks on the filter option
    And User select the category as makeup
    And User selects the brands as life
    And user validates that filter has removed

  @smoke @saanity
  Scenario: Verify functionality of invalid postal code check on the PDP
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And User select a product from wishlist page
    And User validate that it navigates to the PDP
    When user enters an invalid postal code for delivery
    And user clicks on the check option
    And user sees a message indicating to enter a valid postal code

  @smoke @saanity
  Scenario: Verify functionality of valid postal code check on the PDP
#    Given user is on the homepage
#    When user selects a makeup category from home page
#    And user clicks the sub category from makeup page
#    And User select a product from wishlist page
    When user enters an valid postal code for delivery
    And user clicks on the check option

  @smoke @saanity
  Scenario: Verify the logout functionality
#    When user clicks the Menu button for Login
    And user clicks on the Logout button
    Then validate that the user is logged out
