Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/demo/{product} for getting the products.
### Available products: "orange", "apple", "pasta", "cola"
### Prepare Positive and negative scenarios

    @smokeTest
    Scenario Outline: user has possibility to search the available products
      When user performs the search product of "<product>"
      Then response has 200 status code

      Examples:
        | product |
        | apple   |
        | orange  |
        | pasta   |
        | cola    |

    @smokeTest
    Scenario Outline: user has possibility to search the available products
      When user performs the search product of "<product>"
      Then the user sees empty product details response body

      Examples:
        | product |
        | apple   |
        | orange  |

    @smokeTest
    Scenario: user has no possibility to search the unavailable products
      When user performs the search product of "car"
      Then response has 404 status code
      Then response contains an error "Not found"

    @smokeTest
    Scenario: search result for apple product contains the specific items
    When user performs the search product of "pasta"
    Then the search result contains product items
      | title                            | brand                            | price | isPromo |
      | Grand'Italia Tortellini formaggi | GranFood B.V.                    | 5.24  | false   |
      | Djawa Tamarinde pasta            | Vanka-Kawat Daily Amsterdam B.V. | 3.1   | false   |