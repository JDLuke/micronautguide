Feature: Application startup
  Scenario: Successful Run
    Given The application has been started
    When I send a GET request to "/endpoints/health"
    Then The response status should be 200
