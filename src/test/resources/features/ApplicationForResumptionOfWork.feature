Feature: Select the product

  Background: I'd like to fill in the application form for the resumption of work
    Given I have open the enterprise resume work application data submission form
    And I have chosen to Continuous production/start-up enterprises and institutions in the options group

  @Debug
  Scenario: pop up to the next page
    When I click the next page button
    Then The page will redirect to the specified address

  Scenario: Fill in the letter of commitment
    And I have already choose the right application date
    And I filled in the applicant's name correctly
    And  have filled in the applicant's contact information correctly
    When I click the next page button
    Then The page will redirect to the specified address

  Scenario: Fill in the company filing form
    And The reporting company is filled in correctly
    And Fill in the correct number of employees

    When Dan selects product P10
    Then Dan should see below terms in order:
     | frame limit contract | PTC | INS |

