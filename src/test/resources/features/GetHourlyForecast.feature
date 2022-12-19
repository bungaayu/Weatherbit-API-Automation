Feature: Retrieves hourly forecast

  Scenario Outline: Retrieves hourly forecast with valid parameters
    Given set path get hourly forecast with postal_code <postal_code> hours <hours> and key "<key>"
    When send request get hourly forecast
    Then should return 200 ok
    And assert response body get hourly forecast to json schema
    Examples:
    |postal_code|hours|key|
    |28546      |3    |c93890cd35004f6aaa0b1d2f0348a117|
