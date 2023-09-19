package org.example.tests;

import org.example.pojo.Post;
import org.example.utilities.Utils;
import org.testng.Assert;

public class GetPostsByUser {

  public void getUserOnePosts(){
    Post[] userOnePosts= Utils.getPostByUserReq(1)
        .when().get("/posts")
        .then().spec(Utils.resOk()).extract().response().as(Post[].class);
//    Assert length of array is correct
    Assert.assertEquals(userOnePosts.length,10);
//    Check user ID is 1 for all users
    for(Post post:userOnePosts) {
      Assert.assertEquals(post.getUserId(), 1);
    }
//    Check fields are correct for a post
    Assert.assertEquals(userOnePosts[4].getId(),5);
    Assert.assertEquals(userOnePosts[4].getBody(),"repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque");
    Assert.assertEquals(userOnePosts[4].getTitle(),"nesciunt quas odio");
  }

  public void getZeroUserPosts(){
    Post[] userOnePosts= Utils.getPostByUserReq(0)
        .when().get("/posts")
        .then().spec(Utils.resOk()).extract().response().as(Post[].class);
//    Assert array is empty
    Assert.assertEquals(userOnePosts.length,0);
  }

  public void getInvalidUserPosts(){
    Post[] userOnePosts= Utils.getPostByUserReq(101)
        .when().get("/posts")
        .then().spec(Utils.resOk()).extract().response().as(Post[].class);
//    Assert array is empty
    Assert.assertEquals(userOnePosts.length,0);
  }
}
