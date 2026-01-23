#@wishlist
Feature: Verify the wishlist Functionality

  Background:
    Given user launches the application
    When user clicks the Menu button for Login
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status

  @sanity @wishlist
  Scenario: Verifying all the components in homepage for guest user
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    When user clicks on the wishlist icon in the header
    Then system should display the following components on the wishlist page
      | productWishlisted |
      | search            |
      | homeButton        |
      | emptyCartBtn      |
    And User validate that wishlist icon navigate to the wishlist page
    Then User validates wishlist product count in wishlist page
    And user validates product remove x mark in wishlist page

  @sanity
  Scenario: Verifying user remove wishlist items from PDP, PLP, and Wishlist page
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And User remove a product to the wishlist from PLP
    And User validate that product removed from wishlist
#    And User adds a product to the wishlist from PLP
#    And User validate that it navigates to the PDP
#    And User adds a product to the wishlist from PLP
#    And User validate that it navigates to the PDP






