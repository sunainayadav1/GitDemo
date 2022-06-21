@tag
Feature: Validating WorkLoad API in US

  @tag1
  Scenario Outline: Generate token by providing credentials
    Given authorisation paylod with "<clientId>" "<clientSecret>"
    When user call "/v1/auth" with POST http request
    Then API call will get success with status code 200
    And "token" is  "value" generated in response body

  Examples:
  |clientId |clientSecret                                            |
  |PaNextBE |.j2F}?,A9Y-.ii'A@<T?o{^V:nzhnuxw>pariT!P6~-jWKnK@64mF_C=|