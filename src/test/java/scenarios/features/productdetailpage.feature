#@PDP
Feature: Verify the product detail page Functionality

  Background:
    Given user launches the application
    When user clicks the Menu button for Login
    And user enters the valid mobile number
    And user clicks the Continue button
    Then user enters the OTP
    And user validates otp result
    And system should display the appropriate login status

  @Regression @TC_129
  Scenario: Verifying components on the PDP
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

  @Regression @TC_130  #Comment Background to run this testcase
  Scenario: Verifying brand link functionality
    Given user launches application of a product
    And User validates dotAndKey label from makeup PLP

  @Regression @TC_131
  Scenario: Verifying wishlisting the product
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then User clicks on the add to favourite in PDP
    And User validate that product added to wishlist

  @Regression @TC_133
  Scenario: Verifying View Similar button
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
    Then User clicks on the view similar products icon in PDP
    And User validates similar products

  @Regression @TC_134
  Scenario: Verifying share functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then User clicks on the share icon in PDP
    Then system should display the following components on the share options page
      | share it with friends |
      | facebook              |
      | whatsapp              |
      | pinterest             |
      | email                 |

  @Regression @TC_139
  Scenario: Verifying adding to cart/wishlist from Similar Products widget
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll to similar products product
    And Move to similar product from PDP and click on add to bag
    And User validate that product added to cart from PDP
    Then User clicks on the add to favourite from similar product in PDP
    And User validate that product added to wishlist

  @Regression @TC_140
  Scenario: Verifying adding to cart/wishlist from Similar Products widget
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll to customers also bought product
    And Move to customers also bought from PDP and click on add to bag
    And User validate that product added to cart from PDP
    Then User clicks on the add to favourite from customers also bought in PDP
    And User validate that product added to wishlist

  @Regression @TC_141
  Scenario: Verifying adding to cart/wishlist from Similar Products widget
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll to customers also bought product
    And Move to customers also bought from PDP and click on add to bag
    And User validate that product added to cart from PDP
    Then User clicks on the add to favourite from customers also bought in PDP
    And User validate that product added to wishlist

#  @Regression @TC_143  #manual bug
#  Scenario: Verifying Write a Review link functionality
#    When user selects a makeup category from home page
#    And user clicks the sub category from makeup page
#    And user selects a product from plp
#    And User clicks on the view details
#    And User switch new window
#    Then Scroll and click on write a review
#    Then system should display the following components on write a review popup
#      | Write a review |
#      | add photos     |

  @Regression @TC_144
  Scenario: Verifying Write a Review button functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll and click on write a review
    Then system should display the following components on write a review popup
      | Write a review          |
      | Add photos              |
      | Rating for this product |

  @Regression @TC_145
  Scenario: Verifying Write a Review button functionality
    When user selects a makeup category from home page
    And user clicks the sub category from makeup page
    And user selects a product from plp
    And User clicks on the view details
    And User switch new window
    Then Scroll and click on write a review
    And system should display the following components on write a review popup
      | Write a review          |
      | Add photos              |
      | Rating for this product |
    And Select ratings star from write a review popup
    Then User enters review title in review title textbox
    And User enters review description in review title textbox
    And Click on add review button from write a review popup
    Then Validate review submitted message in submitted popup

  @Regression @TC_147 @PDP
  Scenario: Verifying Add to Bag functionality
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
    And User clicks on the add to bag in PDP
    And User validate that product added to cart from PDP
    Then Get Product name from PDP
    When user clicks on the cart icon in the header
    And user validate that cart is not empty
    Then Get First Product name in the cart page
    And Validate PDP product name and added cart product name








