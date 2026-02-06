#@PLP
Feature: Verify the product listing page Functionality

  Background:
    Given user launches the application
    When user clicks the Menu button for Login
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status

  @Regression @TC_110
  Scenario: Verifying PLP opens via all the triggering points
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    Then user validates foundations label from PLP
    And user enters lipstick in searchBox
    And User validates lipstick label from makeup PLP

  @Regression @TC_111
  Scenario: Verifying “View Details” and “Add to Bag” buttons on the product card behave correctly when the user hovers over the card.
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    Then User hover on product and validate options

  @Regression @TC_112
  Scenario: Verifying PLP shows “Select Shade” & “Select Size” options on hovering for products with variants
    Then user enters selectShade product in searchBox
    And User validates product shade popup text

  @Regression @TC_113
  Scenario: Verifying variants (Select Shade & Select Size) ear on hover and function correctly
    Then user enters selectShade product in searchBox
    And User validates product shade popup text
    Then user selects product shade variant in popup
    And User validate that product added to cart
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And user verify product shade variant name in cart page

  @Regression @TC_114
  Scenario: Verifying product details on the tile along with discounts if any
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then Validate product count for searched keyword
    Then user validates foundations label from PLP
    Then system should display the following components on the PLP page
      | Foundation Label        |
      | Sort By                 |
      | Low To High sort option |
      | High To Low sort option |
      | Filters                 |
      | Brand                   |
    And Validate upArrow button scroll page from PLP
    Then user validates foundations label from PLP

  @Regression @TC_115
  Scenario: Verifying product details on the tile along with discounts if any
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then system should display the following product info on the PLP product

  @Regression @TC_116
  Scenario: Verifying applying filters by checking a required filter box
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then Get Product name from PLP
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    Then Get Product name from PLP after applying sugar brand filter

  @Regression @TC_117
  Scenario: Verifying single filter functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then Get Product name from PLP
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    Then Get Product name from PLP after applying sugar brand filter

  @Regression @TC_118 @PLP
  Scenario: Verifying single filter functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then Get Product name from PLP
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    Then Get Product name from PLP after applying sugar brand filter

  @Regression @TC_119
  Scenario: Verifying Reset button on the filters
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then Get Product name from PLP
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    Then Get Product name from PLP after applying sugar brand filter
    And Click on Clear all button on filters
    Then Get Product name from PLP

  @Regression @TC_120
  Scenario: Verifying sort functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    Then User clicks on the sort option
    And User selects a sort option as price low to high
    And user validates products sort by
    Then User clicks on the price high to low from sort by
    And Validate high to low price in sort by
    Then User clicks on the price low to high from sort by
    And Validate low to high price in sort by

  @Regression @TC_122
  Scenario: Verifying wishlisting the product by ting the heart icon
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    And User adds a product to the wishlist from PLP
    Then User validate that product removed from wishlist

  @Regression @TC_123
  Scenario: Verifying Add to Cart Button on the product tile
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And User clicks on the add to bag
    And User validate that product added to cart

  @Regression @TC_124
  Scenario: Verifying View Details functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then system should display the following components on the PDP page
      | prize           |
      | offer           |
      | description     |
      | similar product |
      | review          |


  @Regression @TC_126
  Scenario: Verifying PLP shows the page topic (Category, Brand, or Search Keyword) with correct product counts
    Then user enters keyword in searchBox
    And User validates makeup label from makeup PLP
    And Validate product count for searched keyword
    Then User clicks on brand filter
    And User selects sugar filter from brand
    And User validate sugar label from filtered brand
    And User selects sugar filter from brand
    Then User clicks on brand filter
    Then User clicks on categories filter
    And User selects face filter from brand
    And User validate face label from filtered brand
