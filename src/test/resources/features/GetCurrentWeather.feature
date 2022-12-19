Feature: Retrieves current weather data

  Scenario Outline: Retrieves current weather data with valid parameters
    Given set path get current weather with lat <lat> lon <lon> and key "<key>"
    When send request get current weather data
    Then should return 200 ok
    And response body count should be 1
    And assert response body get current weather to json schema
    Examples:
    |lat|lon|key|
    |40.730610|-73.935242|c93890cd35004f6aaa0b1d2f0348a117|


