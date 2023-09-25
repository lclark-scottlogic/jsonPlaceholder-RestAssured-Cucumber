Feature: Get Post By Id
  @GetPostById
  Scenario Outline:Verify we can get specific posts
    Given PostId is <id>
    When User calls GET endpoint for post
    Then Status code is 200
    And Post belongs to correct user
    And "id" in response body is <id>
    And "title" in response body is <title>
    And "body" in response body is <body>
    Examples:
      |id|title                                                                                                           |body                                                                                                                                                                |
      |1  | "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"                                  | "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"|
      |100|"at nam consequatur ea labore ea harum"                                                                        |         "cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut"    |
@GetPostById
  Scenario Outline:Verify we cannot get post with invalid Id
    Given PostId is <id>
    When User calls GET endpoint for post
    Then Status code is 404
    Examples:
      | id |
      |101 |
      |0   |
      |-1  |


