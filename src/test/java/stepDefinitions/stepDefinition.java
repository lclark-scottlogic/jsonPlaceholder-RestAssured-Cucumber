package stepDefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.example.pojo.Post;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefinition extends Utils {
  RequestSpecification res;
  TestDataBuild data=new TestDataBuild();
  Post updatePostTitle=new Post();
  @Given("New post with title {string}")
  public void new_post_with_title(String title) {
    res=createPostReq(data.updatePostTitlePayload(title));
  }
  @Given("New post with body {string}")
  public void new_post_body_with(String body) {
    res=createPostReq(data.updatePostBodyPayload(body));
  }
  @When("User calls {string} endpoint with Put method")
  public void user_calls_endpoint_with_put_method(String resource) {
  updatePostTitle = res
        .when().put("posts/1")
        .then().spec(resOk()).extract().response().as(Post.class);
  }

  @Then("{string} in response body is {string}")
  public void in_response_body_is_string(String key, String value) {
    assertEquals(value, updatePostTitle.getJsonString(key));
  }

  @Then("{string} in response body is {int}")
  public void in_response_body_is_int(String key, int value) {
    assertEquals(value,updatePostTitle.getJsonInt(key));
  }

}
