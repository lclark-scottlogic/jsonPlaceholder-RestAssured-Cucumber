Feature: Get All Nested Resources
  @GetNestedResources
  Scenario Outline: Verify we can get a post's comments
    Given PostId is <postId>
    When User calls "postComments" endpoint with "GET" method
    Then Comment array has length 5
    And Resource at index <index> has "name" with value <name>
    And Resource at index <index> has "postId" with value <postId>
    And Resource at index <index> has "email" with value <email>
    And Resource at index <index> has "body" with value <body>
    And Resource at index <index> has "id" with value <id>
    Examples:
     |index |postId  |id     |name                                    |email               |body                                                                                                                                                                   |
     |0     |1       |1      |"id labore ex et quam laborum"          |"Eliseo@gardner.biz"|"laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"              |
     |4     |9       |45     |"autem illo facilis"                    |"Marcia@name.biz"   |"ipsum odio harum voluptatem sunt cumque et dolores\nnihil laboriosam neque commodi qui est\nquos numquam voluptatum\ncorporis quo in vitae similique cumque tempore"  |
     |3     |5       |24     |"in tempore eos beatae est"             |"Jeffery@juwan.us"  |"repudiandae repellat quia\nsequi est dolore explicabo nihil et\net sit et\net praesentium iste atque asperiores tenetur"                                              |
  @GetNestedResources
  Scenario: Verify we cannot get an invalid post's comments
    Given PostId is 101
    When User calls "postComments" endpoint with "GET" method
    Then Comment array has length 0
  @GetNestedResources
Scenario Outline: Verify we can get a post's photos
  Given PostId is <postId>
  When User calls "albumPhotos" endpoint with "GET" method
  Then Photo array has length 50
  And Resource at index <index> has "title" with value <title>
  And Resource at index <index> has "albumId" with value <postId>
  And Resource at index <index> has "url" with value <url>
  And Resource at index <index> has "thumbnailUrl" with value <thumbnailUrl>
  And Resource at index <index> has "id" with value <id>
  Examples:
    |index |postId     |id        |title                                                      |url                                       |thumbnailUrl                                    |
    |36    |2          |87        |"eos nihil sunt accusantium omnis"                         |"https://via.placeholder.com/600/224566"  |"https://via.placeholder.com/150/224566"        |
    |49    |100        |5000      |"error quasi sunt cupiditate voluptate ea odit beatae"     |"https://via.placeholder.com/600/6dd9cb"  |"https://via.placeholder.com/150/6dd9cb"        |
    |0     |1          |1         |"accusamus beatae ad facilis cum similique qui sunt"       |"https://via.placeholder.com/600/92c952"  |"https://via.placeholder.com/150/92c952"        |
  @GetNestedResources
  Scenario: Verify we cannot get an invalid post's photos
    Given PostId is 101
    When User calls "albumPhotos" endpoint with "GET" method
    Then Photo array has length 0
  @GetNestedResources
  Scenario Outline: Verify we can get a user's albums
    Given UserId is <userId>
    When User calls "userAlbums" endpoint with "GET" method
    Then Album array has length 10
    And Resource at index <index> has "title" with value <title>
    And Resource at index <index> has "id" with value <id>
    Examples:
      |index |userId     |id        |title                                                      |
      |3     |7          |64        |"autem voluptatem amet iure quae"                          |
      |9     |10         |100       |"enim repellat iste"                                       |
      |0     |1          |1         |"quidem molestiae enim"                                    |

    @GetNestedResources
    Scenario: Verify we cannot get an invalid user's albums
    Given UserId is 11
    When User calls "userAlbums" endpoint with "GET" method
    Then Album array has length 0
  @GetNestedResources
  Scenario Outline: Verify we can get a user's todos
    Given UserId is <userId>
    When User calls "userTodos" endpoint with "GET" method
    Then Todo array has length 20
    And Resource at index <index> has "title" with value <title>
    And Resource at index <index> has "id" with value <id>
    Examples:
      |index |userId     |id        |title                                                      |
      |16    |8          |157       |"dolorem veniam quisquam deserunt repellendus"             |
      |19    |10         |200       |"ipsam aperiam voluptates qui"                             |
      |0     |1          |1         |"delectus aut autem"                                       |
  @GetNestedResources
  Scenario: Verify we cannot get an invalid user's albums
    Given UserId is 11
    When User calls "userTodos" endpoint with "GET" method
    Then Todo array has length 0
