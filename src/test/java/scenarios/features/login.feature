@login
Feature: User Login Functionality with Valid and Invalid Data

  @smoke @sanity
  Scenario: Verify the sign-in functionality via phone number for an existing user
    Given user launches the application
    When user clicks the Menu button for Login
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status

  @smoke @sanity
  Scenario: Verify the logout functionality
    And user clicks on the Logout button
    Then validate that the user is logged out

  @smoke @sanity
  Scenario: Verify the OTP functionality with an invalid OTP and resend functionality
    Given user launches the application
    When user clicks the Menu button for Login
    And user enters the mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result for invalid otp
    And user clicks on the Resend SMS option
    And user successfully resends the OTP
    Then user enters the invalid OTP
    And user validates otp result for invalid otp

  @sanity
  Scenario: Verify the sign-in functionality via phone number with an invalid number
    Given user launches the application
    When user clicks the Menu button for Login
    And user enters the invalid mobile number
    And user clicks the Continue button for invalid number validates
    Then validate that the appropriate error message is displayed

  @smoke @sanity
  Scenario: Verify the functionality of merging the cart from guest user to logged-in user
    Given user launches the application
    Given user is on the homepage
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the add to bag
    And user clicks on the cart icon in the header
    Then user validates the price details in the bag
    And User clicks on the proceed to pay
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status

