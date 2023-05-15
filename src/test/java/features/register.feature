Feature: As a user, I should be able to register successfully
  @register @all
  Scenario: As a user, I should be able to register successfully
    So that, I can use all the user features

    Given I am on homepage
    And I click on the register link
    When I enter required registration details
    Then I should be able to register successfully
