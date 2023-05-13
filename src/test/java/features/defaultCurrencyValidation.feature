Feature: Validating Default Currency
 @test1
 Scenario Outline: Verify the default currency is sent for all the countries
    Given Valid country code "<countryCode>"
    When user calls "currencyListAPI" with "Get" http request
    Then the API call got success with status code 200
    And "base.symbol" in response body is "<currency>"
   Examples:
     |countryCode | currency |
     |SA          | SAR      |
     |AE          | AED      |

  @test2
  Scenario: Verify the flight between UAE and RUH is feached when user clicks on RUH - UAE
    Given The valid payload with country - "UAE" details
    When user calls "flightList" with "POST" http request
    Then the API call got success with status code 200
    And Validate origins and destinations are retrieved

