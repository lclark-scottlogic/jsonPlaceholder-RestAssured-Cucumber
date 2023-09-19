package resources;

import org.example.pojo.Post;

public class TestDataBuild {
  public Post updatePostTitlePayload(){
    Post titlePost = new Post();
    titlePost.setTitle("New Title");
    return titlePost;
  }
}
