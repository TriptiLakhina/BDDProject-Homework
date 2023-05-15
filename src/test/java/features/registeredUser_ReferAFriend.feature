Feature: Email a friend
  @email_a_friend @all
  Scenario: As a registered user, I should be able to refer a product to a friend
    Given I am a registered user
    When I log in
    And I add the product to cart
    And I click on Email a friend Button
    And I fill in Email a friend details
    Then I should be able to see Email a friend success message