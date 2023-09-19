package org.example.tests;

import org.example.pojo.Post;
import org.example.utilities.Utils;
import org.example.utilities.ResSpecBuilders;
import org.testng.Assert;


public class CreatePosts {

    public void createPost() {
//  Instantiate a Post to send to server
  Post myPost = new Post();
  myPost.setTitle("My First Post");
  myPost.setBody("Here is my first post");
  myPost.setUserId(2);
//  Create a Post
  Post createPostAllFieldsFilled = Utils.createPostReq(myPost)
      .when().post("/posts")
      .then().spec(Utils.resCreated()).extract().response().as(Post.class);
//    Make Assertions on the response fields
  Assert.assertEquals(createPostAllFieldsFilled.getId(), 101);
  Assert.assertEquals(createPostAllFieldsFilled.getUserId(), 2);
  Assert.assertEquals(createPostAllFieldsFilled.getTitle(), "My First Post");
  Assert.assertEquals(createPostAllFieldsFilled.getBody(), "Here is my first post");
}

    public void createPostNoTitle() {
  Post noTitlePost = new Post();
  noTitlePost.setBody("Here is my first post");
  noTitlePost.setUserId(2);
//  Create a Post with No Title
  Post createPostNoTitle = Utils.createPostReq(noTitlePost)
      .when().post("/posts")
      .then().spec(Utils.resCreated()).extract().response().as(Post.class);
//    Make Assertions on the response fields
  Assert.assertEquals(createPostNoTitle.getId(), 101);
  Assert.assertEquals(createPostNoTitle.getUserId(), 2);
  Assert.assertNull(createPostNoTitle.getTitle());
  Assert.assertEquals(createPostNoTitle.getBody(), "Here is my first post");
}

  public void createPostNoBody() {
    Post noBodyPost = new Post();
    noBodyPost.setTitle("My First Post");
    noBodyPost.setUserId(2);
    //  Create a Post with No Body
    Post createPostNoBody = Utils.createPostReq(noBodyPost)
        .when().post("/posts")
        .then().spec(Utils.resCreated()).extract().response().as(Post.class);
//    Make Assertions on the response fields
    Assert.assertEquals(createPostNoBody.getId(), 101);
    Assert.assertEquals(createPostNoBody.getUserId(), 2);
    Assert.assertEquals(createPostNoBody.getTitle(), "My First Post");
    Assert.assertNull(createPostNoBody.getBody());
  }

  public void createPostNoUser() {
    Post noUserPost = new Post();
    noUserPost.setTitle("My First Post");
    noUserPost.setBody("Here is my first post");
    //  Create a Post with No UserId
    Post createPostNoUser = Utils.createPostReq(noUserPost)
        .when().post("/posts")
        .then().spec(Utils.resCreated()).extract().response().as(Post.class);
//    Make Assertions on the response
    Assert.assertEquals(createPostNoUser.getId(), 101);
    Assert.assertEquals(createPostNoUser.getUserId(), 0);
    Assert.assertEquals(createPostNoUser.getTitle(), "My First Post");
    Assert.assertEquals(createPostNoUser.getBody(), "Here is my first post");
  }
}

