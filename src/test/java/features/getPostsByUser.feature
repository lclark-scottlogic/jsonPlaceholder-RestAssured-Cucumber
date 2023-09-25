Feature: Get Post By User
  @GetPostByUser
  Scenario Outline:Verify we can get all the posts for a single user
    Given User has Id <userId>
    When User calls "allPosts" endpoint with "GET" method
    Then Array has length 10
    And All posts have userId <userId>
#    Check fields of random post in array
    And Resource at index <index> has "id" with value <id>
    And Resource at index <index> has "body" with value <body>
    And Resource at index <index> has "title" with value <title>
    Examples:
      | id |index|userId| title                                     |body                                                                                                                                                    |
      | 5  |4     |1      |"nesciunt quas odio"                     |"repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque"|
      | 100|9     |10     |"at nam consequatur ea labore ea harum"  |"cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut" |
      | 58 |7     |6      |"voluptatum itaque dolores nisi et quasi"|"veniam voluptatum quae adipisci id\net id quia eos ad et dolorem\naliquam quo nisi sunt eos impedit error\nad similique veniam"                        |


