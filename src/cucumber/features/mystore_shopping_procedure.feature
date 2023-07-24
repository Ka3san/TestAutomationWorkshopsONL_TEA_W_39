Feature: Go through product purchasing procedure

  Scenario Outline: Successful product purchasing process
    Given https://mystore-testlab.coderslab.pl/index.php opened in Google Chrome browser
    When existing user logged in
    And Clothes button clicked
    And Click Hummingbird Printed Sweater tile to purchase
#And Check for a 20% discount
    And Choose M size
    And Choose 5 pcs
    And Click ADD TO CART button
    And Proceed to checkout
    And Address confirmed
    And Self pick up shipping method chosen
    And Pay by Check payment chosen
    And Click Terms Of Service agreement checkbox
    And Click PLACE ORDER button
    Then Takes a screenshot to confirm order and total payment amount

    Examples:
      |  |

#Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
#sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.