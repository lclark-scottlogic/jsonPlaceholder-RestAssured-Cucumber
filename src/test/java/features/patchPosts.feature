Feature: Patch Posts
  Scenario Outline:Verify we can update a specific post's title
    Given We set "title" as <title>
    When User calls "post1" endpoint with "PATCH" method
    Then Status code is 200
    And "id" in response body is 1
    And Post belongs to correct user
    And "title" in response body is <title>
    And "body" in response body is:
    """
  quia et suscipit
  suscipit recusandae consequuntur expedita et cum
  reprehenderit molestiae ut ut quas totam
  nostrum rerum est autem sunt rem eveniet architecto
  """
    Examples:
      | id | title     |body| userId |
      | 0  |"New Title"|null| 0      |
      | 0  |""         |null| 0      |

  Scenario Outline:Verify we can update a specific post's body
    Given We set "body" as <body>
    When User calls "post2" endpoint with "PATCH" method
    Then Status code is 200
    And "id" in response body is 2
    And Post belongs to correct user
    And "title" in response body is "qui est esse"
    And "body" in response body is <body>
    Examples:
      | id |title|body        | userId |
      | 0  |null|"My New Body"| 0      |
      | 0  |null|""           | 0      |

  Scenario Outline:Verify we can update a specific post's userId
    Given We set "userId" as <userId>
    When User calls "post3" endpoint with "PATCH" method
    Then Status code is 200
    And "id" in response body is 3
    And "userId" in response body is 2000
    And "title" in response body is "ea molestias quasi exercitationem repellat qui ipsa sit aut"
    And "body" in response body is:
    """
    et iusto sed quo iure
    voluptatem occaecati omnis eligendi aut ad
    voluptatem doloribus vel accusantium quis pariatur
    molestiae porro eius odio et labore et velit aut
    """
    Examples:
      | id |title|body        | userId |
      | 0  |null|null         | 2000   |
      | 0  |null|null         | 0   |

  Scenario Outline:Verify we can update a specific post's id
    Given We set "id" as <id>
    When User calls "post4" endpoint with "PATCH" method
    Then Status code is 200
    And "id" in response body is <id>
#    userId remains,we just change the post's Id
    And "userId" in response body is 1
    And "title" in response body is "eum et est occaecati"
    And "body" in response body is:
    """
   ullam et saepe reiciendis voluptatem adipisci
sit amet autem assumenda provident rerum culpa
quis hic commodi nesciunt rem tenetur doloremque ipsam iure
quis sunt voluptatem rerum illo velit
    """
    Examples:
      | id |title|body        | userId |
      | 77 |null |null        | 0      |
      | 0  |null |null        | 0      |

