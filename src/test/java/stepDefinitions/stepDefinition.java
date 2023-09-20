package stepDefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.pojo.Post;
import resources.Api;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefinition extends Utils {
//Variables need to be declared at the start because they need to have
//  global scope, so they are reassigned as cucumber step methods run
  RequestSpecification res;
  Response response;
  TestDataBuild data = new TestDataBuild();
  Post post = new Post();

  @Given("New post with {string} {string}")
  public void new_post_with(String parameter,String value) {
    res = createPostReq(data.updatePostPayload(parameter,value));
  }

  @Given("Create post with {int} {int} {string} {string}")
  public void create_post_with_null(int id, int userId, String title,String body) {
    res=createPostReq(data.createPostPayload(id,userId,title,body));

  }

  @When("User calls {string} endpoint with {string} method")
  public void user_calls_endpoint_with_method(String resource, String method) {
//    Constructor is called with value of resource which has been assigned as global resource variable
    Api resourceApi = Api.valueOf(resource);
//    Depending on value of method we use the corresponding HTTP method for our API request
    switch (method.toUpperCase()) {
      case "PUT":
        response = res.when().put(resourceApi.getResource());
        break;
      case "GET":
        response = res.when().get(resourceApi.getResource());
        break;
      case "DELETE":
        response = res.when().delete(resourceApi.getResource());
        break;
      case "PATCH":
        response = res.when().patch(resourceApi.getResource());
        break;
      case "POST":
        response = res.when().post(resourceApi.getResource());
        break;
    }

}

  @Then("Status code is {int}")
  public void status_code_is_int(int code){
    switch(code) {
      case 200:
        post = response.then().spec(resOk()).extract().response().as(Post.class);
        break;
      case 201:
        post = response.then().spec(resCreated()).extract().response().as(Post.class);
        break;
      case 404:
        String error=response.then().spec(resNotFound()).extract().response().asString();
        break;

    }
  }
  @Then("{string} in response body is {string}")
  public void in_response_body_is_string(String key, String value) {
    assertEquals(value, post.getJsonString(key));
  }
  @Then("{string} in response body is {int}")
  public void in_response_body_is_int(String key, int value) {
    assertEquals(value,post.getJsonInt(key));
  }




}
