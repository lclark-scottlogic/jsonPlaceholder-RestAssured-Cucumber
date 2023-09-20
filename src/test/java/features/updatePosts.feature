Feature: Update Posts

  Scenario Outline: Verify we can update a post's title
    Given New post with "title" <title>
    When User calls "post1" endpoint with "PUT" method
    Then Status code is 200
    And "id" in response body is 1
    And "title" in response body is <title>

    Examples:
      | id | title     |body| userId |
      | 0  |"New Title"|null| 0      |
      | 0  |""         |null| 0      |

  Scenario Outline: Verify we can update a post's body
    Given New post with "body" <body>
    When User calls "post1" endpoint with "PUT" method
    Then Status code is 200
    And "id" in response body is 1
    And "body" in response body is <body>
    Examples:
      | id | title     | body                   | userId |
      | 0  | null      |"This is my newest post"| 0      |
      | 0  |null       |""                      | 0      |


