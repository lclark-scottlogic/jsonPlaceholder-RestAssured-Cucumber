Feature: Delete Posts
  Scenario: Verify we can delete a specific post
    Given PostId is 1
    When User calls "post1" endpoint with "DELETE" method