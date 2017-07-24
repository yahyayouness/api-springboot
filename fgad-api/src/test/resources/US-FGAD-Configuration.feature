Feature: Get the configuration of dev profile
  Scenario: client makes call to GET /fgad/api/config
    When the fgad user calls /fgad/api/config
    Then the fgad user receives status code of 200
    And the fgad user receives uri document http://localhost:8080/ged-dfc-api/fgad/api/clients/synchrone