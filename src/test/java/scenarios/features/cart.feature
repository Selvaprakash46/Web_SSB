#@cart
Feature: Verify the Cart Page Functionality

  Background:
    Given user launches the application
    When user clicks the Menu button for Login
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status

  @smoke @sanity
  Scenario: Adding the Product to cart
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the add to bag

  @smoke @sanity
  Scenario: Adding the Product to cart
    Given user is on the homepage
    When user selects a hair category from home page
    And user clicks the sub category from hair page
    And user selects a product from plp
    And User clicks on the add to bag

  @smoke @sanity
  Scenario: Adding the Product to cart
    Given user is on the homepage
    When user selects a skin category from home page
    And user clicks the sub category from skin page
    And user selects a product from plp
    And User clicks on the add to bag

  @smoke @sanity
  Scenario: Verify the components of the Bag
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    Then system should display the following components on the cart page
      | Bag          |
      | Address      |
      | Payment      |
      | Best coupons for you |

  @smoke @sanity
  Scenario: Verify increase and decrease of product quantity
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And user increase the product quantity in the cart
    And user decrease the product quantity in the cart

  @smoke @sanity
  Scenario: Verify adding/removing product to bag from PDP and move to Wishlist
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    And user clicks on the product x mark
    And user moves a product to the wishlist from the cart
    And user validate that product moved to wishlist
    And user validate that cart is not empty
    Then user clicks on the product x mark
    And user removes a product to the wishlist from the cart
    And user validate that product removed from cart

  @smoke @sanity @TC020 @cart
  Scenario: Verify functionality of invalid postal code check on the cart page
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    When User clicks on the proceed to pay
#    Then user clicks on the check option to validate the postal code
    And user enters an invalid postal code
    And system should display the appropriate error message

  @smoke @sanity @TC020
  Scenario: Verify functionality of valid postal code check on the cart page
#    When user clicks on the cart icon in the header
#    And user validate that cart is not empty
#    Given user clicks on the check option to validate the postal code
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    When User clicks on the proceed to pay
    When user enters the postal code

  @sanity
  Scenario: Verify Move to Wishlist functionality
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And User adds a product to the wishlist from PLP
    And User validate that product added to wishlist
    When user clicks on the wishlist icon in the header
    And user validate that wishlist is not empty

  @sanity
  Scenario: Verify to ensure redirect to Home via SSB logo
    Given user is on the homepage
    When user clicks on the cart icon in the header
    And user clicks SSBeauty logo to return to homepage

  @sanity
  Scenario: Verify to ensure redirect to Home via SSB logo
    Given user is on the homepage
    When user clicks on the cart icon in the header
    Then user clicks on the view all from your wishlist in cart page
    And user validate that wishlist is not empty


