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

  @sanity @TC_112
  Scenario: Verifying PLP shows “Select Shade” & “Select Size” options on hovering for products with variants
    Then user enters selectShade product in searchBox
    And User validates product shade popup text

  @sanity @TC_113
  Scenario: Verifying variants (Select Shade & Select Size) ear on hover and function correctly
    Then user enters selectShade product in searchBox
    And User validates product shade popup text
    Then user selects product shade variant in popup
    And User validate that product added to cart
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And user verify product shade variant name in cart page