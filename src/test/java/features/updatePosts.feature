Feature:
  Scenario: Verify we can update a post's title
    Given New post title
    When User calls "posts/1" endpoint with Put method
    Then "title" in response body is "New Title"
    And "id" in response body is "1"