package org.example.tests;

import io.restassured.path.json.JsonPath;
import org.example.utilities.GetDetails;
import org.example.utilities.Utils;
import org.example.utilities.ResSpecBuilders;
import org.testng.Assert;

public class GetAllPosts {


  public void getAllPosts() {
//    Get all Posts
    String getAllPosts = Utils.getAllPostReq()
        .when().get("/posts")
        .then().spec(Utils.resOk()).extract().response().asString();
//    Check the array is correct via assertions
    JsonPath js=new JsonPath(getAllPosts);
    Assert.assertEquals(js.get("[0].title"),"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    Assert.assertEquals(js.get("[99].title"),"at nam consequatur ea labore ea harum");
//    Check the values of a few random objects in the json
    Assert.assertEquals((Integer) js.get("[78].id"),79);
    Assert.assertEquals((Integer) js.get("[78].userId"), GetDetails.getUserIdFromPostId(79));
    Assert.assertEquals(js.get("[26].body"),"eum sed dolores ipsam sint possimus debitis occaecati\ndebitis qui qui et\nut placeat enim earum aut odit facilis\nconsequatur suscipit necessitatibus rerum sed inventore temporibus consequatur");

  }
}

