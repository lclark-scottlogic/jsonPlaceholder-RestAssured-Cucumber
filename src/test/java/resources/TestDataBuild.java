package resources;

import org.example.pojo.Post;

public class TestDataBuild {
  public Post updatePostTitlePayload(String title){
    Post titlePost = new Post();
    titlePost.setTitle(title);
    return titlePost;
  }

  public Post updatePostBodyPayload(String body) {
    Post bodyPost = new Post();
    bodyPost.setBody(body);
    return bodyPost;
  }
}
