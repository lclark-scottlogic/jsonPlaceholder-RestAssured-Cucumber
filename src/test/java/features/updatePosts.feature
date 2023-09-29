Feature: Update Posts
@UpdatePost
  Scenario Outline: Verify we can update a post's title
    Given New post with <case> "title"
    When User calls "post1" endpoint with "PUT" method
    Then Status code is 200
    And "id" in response body is 1
    And "title" in response body is <title>

    Examples:
      |case  | id | title     |body| userId |
      |"data1"| 0  |"New Title"|null| 0      |
      |"data2"| 0  |null       |null| 0      |
  @UpdatePost
  Scenario Outline: Verify we can update a post's body
    Given New post with <case> "body"
    When User calls "post1" endpoint with "PUT" method
    Then Status code is 200
    And "id" in response body is 1
    And "body" in response body is <body>
    Examples:
      |case   | id | title     | body                   | userId |
      |"data3"| 0  | null      |"This is my newest post"| 0      |
      |"data4"| 0  |null       |null                    | 0      |



