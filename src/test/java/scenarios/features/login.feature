
Feature: User Login Functionality with Valid and Invalid Data

  Background:
    Given user launches the application


  @smoke @sanity @login
  Scenario: Verify the sign-in functionality via phone number for an existing user
    When user clicks the Menu button for Login
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status

  @smoke @sanity @login
  Scenario: Verify the logout functionality
    Given user clicks the Menu button for Login
    When user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status
    And user clicks on the Logout button
    Then validate that the user is logged out

  @smoke @sanity @login
  Scenario: Verify the OTP functionality with an invalid OTP and resend functionality
    Given user clicks the Menu button for Login
    When user enters the mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result for invalid otp
    And user clicks on the Resend SMS option
    And user successfully resends the OTP
    Then user enters the invalid OTP
    And user validates otp result for invalid otp

  @sanity @login
  Scenario: Verify the sign-in functionality via phone number with an invalid number
    Given user clicks the Menu button for Login
    When user enters the invalid mobile number
    And user clicks the Continue button for invalid number validates
    Then validate that the appropriate error message is displayed

  @smoke @sanity @login
  Scenario: Verify the functionality of merging the cart from guest user to logged-in user
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