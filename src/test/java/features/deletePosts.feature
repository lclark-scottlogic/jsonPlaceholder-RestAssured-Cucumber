Feature: Delete Posts
  @DeletePost
  Scenario: Verify we can delete a specific post
    Given All posts request
    When User calls "post1" endpoint with "DELETE" method
    Then Status code is 200