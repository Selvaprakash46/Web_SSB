@checkout
Feature: Checkout Process and Order Placement

#  @smoke @sanity
#  Scenario: Verify the sign-in functionality via phone number for an existing user
#    Given user launches the application
#    When user clicks the Menu button for Login
#    And user enters the valid mobile number
#    And user clicks the Continue button
#    Then user enters the OTP
#    And user validates otp result
#    And system should display the appropriate login status

 @smoke @sanity @act
  Scenario: Verify a successful payment
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the add to bag
    And user clicks on the cart icon in the header
    Then user validates the price details in the bag
    And User clicks on the proceed to pay
    And user validates the price details in the bag
    And User clicks on the continue to payment
    And user validates the price details in the bag
    And user selecting cod option
    And User clicks on the place order button
    And User validate that the order is placed successfully

  @smoke @sanity
  Scenario: Verify navigation to the successful order summary page
    Then user validates the successful order summary
    Then user clicks on the Continue Shopping button

 @smoke @sanity
  Scenario: Failed Order Placement
   Given user launches the application
   Given user is on the homepage
   When user selects a makeup category from home page
   And user clicks the sub category from makeup page
   And user selects a product from plp
   And User clicks on the add to bag
   And user clicks on the cart icon in the header
   Then user validates the price details in the bag
   And User clicks on the proceed to pay
   And user validates the price details in the bag
   And User clicks on the continue to payment
   And user validates the price details in the bag
   And user selecting UPI option
   And user enters the UPI id
   And user validates that UPI id
   And User validate that an error message indicating payment failure

