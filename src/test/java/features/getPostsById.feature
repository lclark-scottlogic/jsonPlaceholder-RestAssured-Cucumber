Feature: Get Post By Id
  Scenario:Verify we can get the first post
    Given PostId is 1
    When User calls GET endpoint for post
    Then Status code is 200
    And Post belongs to correct user
    And "id" in response body is 1
    And "title" in response body is "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
    And "body" in response body is:
    """
    quia et suscipit
    suscipit recusandae consequuntur expedita et cum
    reprehenderit molestiae ut ut quas totam
    nostrum rerum est autem sunt rem eveniet architecto
    """