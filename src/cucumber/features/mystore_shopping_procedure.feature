Feature: Go through product purchasing procedure

  Scenario Outline: Successful product purchasing process
    Given https://mystore-testlab.coderslab.pl/index.php is opened in Google Chrome browser
    When Existing user logged in with given '<email>' and '<password>'
    And Click Clothes button in top menu
    And Click Hummingbird Printed Sweater tile to purchase
    And Check for a 20% discount
    And Choose '<size>' size
    And Choose '<quantity>' pcs
    And Click ADD TO CART button
    And Proceed to checkout
    And Address confirmed
    And Self pick up shipping method chosen
    And Pay by Check payment chosen
    And Click Terms Of Service agreement checkbox
    And Click PLACE ORDER button
    Then Takes a screenshot to confirm order and total payment amount
    And Go to the Orders history and details page
    And Check if an order is on the 'Awaiting check payment' list
    And Compare Total price with order confirmation page

    Examples:
      | email                 | password | size | quantity |
      | randomuser@mystore.nl | Pass666  | M    | 5        |


