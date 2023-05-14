Feature: Validating Default Currency and Flight details
 @test1 @get
 Scenario Outline: Verify the default currency is sent for all the countries
    Given Valid country code "<countryCode>"
    When user calls "currencyListAPI" with "Get" http request
    Then the API call got success with status code 200
    And "base.symbol" in response body is "<currency>"
   Examples:
     |countryCode | currency |
     |SA          | SAR      |
     |AE          | AED      |

  @test2 @post
  Scenario: Verify the flight between UAE and RUH is feached when user clicks on RUH - UAE
    Given The valid payload with country code - "ae"
    When user calls "flightList" with "POST" http request
    Then the API call got success with status code 200
    And Validate origins "RUH" and destinations "DXB" are available in Response

