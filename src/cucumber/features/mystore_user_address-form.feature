Feature: Mystore user address form filling and check

  Scenario Outline: Successful fill in address form of existing user and confirm operation
    Given https://mystore-testlab.coderslab.pl/index.php opened in Google Chrome browser
    When Sign In button clicked
    And '<email>' and '<password>' filled
    And SIGN IN button clicked
    And Addresses link from bottom 'YOUR ACCOUNT' block clicked
    And + Create new address button clicked
    And New address form filled with '<alias>', '<address>', '<city>', '<zip/postal code>', '<country>', '<phone>'
    And Save button clicked
    Then Check if the filled data is correct
#And Delete the above address
#And Check if the above address has been deleted

    Examples:

      | phone     | email                 | password | alias  | address | city      | zip/postal code | country       |
      | 765342984 | randomuser@mystore.nl | Pass666  | qwerty | ArenA   | Amsterdam | 10-100          | United Kingdom|