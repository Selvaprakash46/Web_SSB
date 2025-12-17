@header
Feature: Verify the Header Functionality

#  @smoke @sanity
#  Scenario: Verify the sign-in functionality via phone number for an existing user
#    Given user launches the application
#    When user clicks the Menu button for Login
#    And user enters the valid mobile number
#    And user clicks the Continue button
#    Then user enters the OTP
#    And user validates otp result
#    And system should display the appropriate login status

@smoke @sanity
  Scenario: Verify the Wishlist Functionality
  Given user launches the application
    Given user is on the homepage
    When User clicks on the wishlist icon in the header
    And User validate that wishlist icon navigate to the wishlist page
    And User select a product from wishlist page
    And User validate that it navigates to the PDP
    And User clicks on the wishlist icon in the header
    And User adds a product to the cart from the wishlist page
    And User validate that product add to cart successfully
    Then User removes a product from the wishlist page
    And User clicks on the remove item for removing product from wishlist
    And User validate that product removed from wishlist

@smoke @sanity
  Scenario: Verify the Search Functionality
    Given user is on the homepage
    When User clicks on the search bar
    And User search with keywords
    And user clicks enter
#    And User validate that search option navigation to the relevant products
    And User clicks on the search bar
    And User clicks on trending products
#    And User validate that search option navigation to the relevant products

