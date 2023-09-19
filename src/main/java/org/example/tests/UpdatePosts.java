package org.example.tests;


import org.example.pojo.Post;
import org.example.utilities.Utils;
import org.testng.Assert;

public class UpdatePosts {

public void updatePostTitle(String title) {
//    Update Post Title
  Post titlePost = new Post();
  titlePost.setTitle(title);
  Post updatePostTitle = Utils.createPostReq(titlePost)
      .when().put("posts/1")
      .then().spec(Utils.resOk()).extract().response().as(Post.class);
  //Assert title has changed
  Assert.assertEquals(updatePostTitle.getTitle(), "New Title");
  Assert.assertEquals(updatePostTitle.getId(), 1);
}
public void updatePostBody() {
  Post bodyPost = new Post();
  bodyPost.setBody("This is my newest post");
  Post updatePostBody = Utils.createPostReq(bodyPost)
      .when().put("posts/1")
      .then().spec(Utils.resOk()).extract().response().as(Post.class);
  //Assert body has changed
  Assert.assertEquals(updatePostBody.getBody(), "This is my newest post");
  Assert.assertEquals(updatePostBody.getId(), 1);
}
}

