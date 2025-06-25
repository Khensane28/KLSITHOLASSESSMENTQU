Feature: End-to-End Purchase Flow

  Scenario: User logs in and customizes a product to add to the cart
    Given User is on the login page
    When User logs in with email "sibongilesithole71@gmail.com" and password "Sibongile71#"
    Then User navigates to the Computers category
    And User selects the Desktops category
    And User Clicks build your own computer
    And User customizes a Build Your Own Computer and adds it to the cart
    Then The product should be successfully added to the cart
