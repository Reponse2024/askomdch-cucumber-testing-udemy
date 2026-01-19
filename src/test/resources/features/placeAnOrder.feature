Feature: Place an order

  Scenario: using default payment option
    Given I'm a guest customer
    And my billing  details are
      | firstname | lastname | country            | address_line1     | city  | state | zip   | email          |
      | Range     | Rover    | United States (US) | 6300 Spring Greek | plano | Texas | 75024 | range@cars.buy |
    And I have a product in the cart
    And I'm on the checkout page
    When I provide billing details
    And I place an order
    Then the order should be placed successfully