package resources;

import java.util.Objects;
import org.example.pojo.Post;

public class TestDataBuild {
  public Post updatePostPayload(String parameter,String value){
    Post post = new Post();
    if(Objects.equals(parameter, "title")) {
      post.setTitle(value);
    } else if(Objects.equals(parameter, "body")) {
      post.setBody(value);
    }
    return post;
  }
  public Post createPostPayload(int id,int userId,String title,String body){
    Post post = new Post();
    post.setTitle(title);
    post.setBody(body);
    post.setId(id);
    post.setUserId(userId);
    return post;
  }
}
