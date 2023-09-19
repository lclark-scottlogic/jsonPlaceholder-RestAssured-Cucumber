package stepDefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pojo.Post;
import org.example.utilities.Utils;
import org.example.utilities.ResSpecBuilders;

public class stepDefinition {
  Post titlePost = new Post();
  Post updatePostTitle=new Post();
  @Given("New post title")
  public void new_post_title() {
    titlePost.setTitle("New Title");
  }
  @When("User calls {string} endpoint with Put method")
  public void user_calls_endpoint_with_put_method(String resource) {
  updatePostTitle = Utils.createPostReq(titlePost)
        .when().put("/{resource}")
        .then().spec(Utils.resOk()).extract().response().as(Post.class);
  }

  @Then("{string} in response body is {string}")
  public void in_response_body_is_string(String key, String value) {
    assertEquals(updatePostTitle.getTitle(), value);
  }

  @Then("{string} in response body is {int}")
  public void in_response_body_is_int(String key, int value) {
    assertEquals(updatePostTitle.getId(), value);
  }


}
