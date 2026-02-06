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

  @Regression @TC_151
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

  @Regression @TC_152
  Scenario: Verifying user remove wishlist items from PDP, PLP, and Wishlist page
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then User adds multiple products to wishlist in PLP
    When user clicks on the wishlist icon in the header
    And User deletes wishlisted products from wishlist page



  @Regression @TC_153
  Scenario: Verifying user can add products to wishlist from all supported surfaces
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then User clicks on the add to favourite in PDP
    And User validate that product added to wishlist
    Then user enters keyword in searchBox
    And User validates makeup label from makeup PLP
    Then User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    When user clicks on the wishlist icon in the header
    Then User validates 3 wishlist product count in wishlist page
    And User deletes wishlisted products from wishlist page

  @Regression @TC_154
  Scenario: Verifying user can remove wishlist items from PDP, PLP, and Wishlist page
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And User adds a product to the wishlist from PLP
    Then User validate that product removed from wishlist
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then User clicks on the add to favourite in PDP
    And User validate that product removed from wishlist
    Then user enters keyword in searchBox
    And User validates makeup label from makeup PLP
    Then User adds a product to the wishlist from PLP
    And User validate that product removed from wishlist
    When user clicks on the wishlist icon in the header
    And user validate that wishlist is empty

  @sanity
  Scenario: Verifying OOS


  @Regression @TC_157
  Scenario: Verifying user can open PDP from Wishlist & add wishlist items to cart
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    When user clicks on the wishlist icon in the header
    And user validate that wishlist is not empty
    And User clicks on the view details
    And User switch new window
    And User clicks on the add to bag in PDP
    And User validate that product added to cart

