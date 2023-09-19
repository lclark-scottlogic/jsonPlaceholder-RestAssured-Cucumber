Feature: Update Posts

  Scenario Outline: Verify we can update a post's title
    Given New post with title <title>
    When User calls "/posts/1" endpoint with Put method
    Then "title" in response body is "New Title"
    And "id" in response body is 1

    Examples:
      | id | title     |body| userId |
      | 0  |"New Title"|null| 0      |

  Scenario Outline: Verify we can update a post's body
    Given New post with body <body>
    When User calls "/posts/1" endpoint with Put method
    Then "body" in response body is "This is my newest post"
    And "id" in response body is 1
    Examples:
      | id | title     | body                   | userId |
      | 0  | null      |"This is my newest post"| 0      |
