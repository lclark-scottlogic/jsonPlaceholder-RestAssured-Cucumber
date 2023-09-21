Feature: Get All Posts
  Scenario Outline: Verify we can retrieve the correct attribute values for posts
    Given All posts request
    When User calls "allPosts" endpoint with "GET" method
#    Indices start at 0
    Then Resource at index <index> has <attribute> with value <value>
    And Post belongs to correct user
    Examples:
#    Validate fields for first, last and nth post, for n a random index between first and last.
      |index  |attribute|value                                                                                                                                                                             |
      |0      |"title"  |"sunt aut facere repellat provident occaecati excepturi optio reprehenderit"                                                                                                      |
      |0      |"body"   |"quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"               |
      |0      |"id"     |1                                                                                                                                                                                 |
      |0      |"userId" |1                                                                                                                                                                                 |
      |99     |"title"  |"at nam consequatur ea labore ea harum"                                                                                                                                           |
      |99     |"body"   |"cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut"                           |
      |99     |"id"     |100                                                                                                                                                                               |
      |99     |"userId" |10                                                                                                                                                                                |
      |78     |"title"  |"pariatur consequatur quia magnam autem omnis non amet"                                                                                                                           |
      |78     |"body"   |"libero accusantium et et facere incidunt sit dolorem\nnon excepturi qui quia sed laudantium\nquisquam molestiae ducimus est\nofficiis esse molestiae iste et quos"               |
      |78     |"id"     |79                                                                                                                                                                                |
      |78     |"userId" |8                                                                                                                                                                                 |
