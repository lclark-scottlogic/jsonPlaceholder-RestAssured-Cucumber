package resources;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.example.pojo.Post;

public class Utils {

  public static RequestSpecification baseReq() {
//    try/catch for case that no such logging file exists
    PrintStream log = null;
    try {
      log = new PrintStream(new FileOutputStream("logging.txt"));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    return new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com")
        .setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(
            ResponseLoggingFilter.logResponseTo(log)).build();
  }
  public static RequestSpecification createPostReq(Post post){
    return given().spec(baseReq()).body(post);
  }
  public static RequestSpecification getPostReq(int id){
    return given().spec(baseReq()).pathParam("id",id);
  }
  public static RequestSpecification getAllPostReq(){
    return given().spec(baseReq());
  }
  public static RequestSpecification deletePostReq(int id){
    return given().spec(baseReq()).pathParam("id",id);
  }
  public static RequestSpecification getPostByUserReq(int id){
    return given().spec(baseReq()).queryParam("userId",id);
  }
  public static RequestSpecification patchPostReq(String Json,int id){
    return given().spec(baseReq()).body(Json).pathParam("id",id);
  }

  public static ResponseSpecification resOk(){
    return new ResponseSpecBuilder()
        .expectStatusCode(200)
        .expectContentType(ContentType.JSON).build();
  }
  public static ResponseSpecification resCreated(){
    return new ResponseSpecBuilder()
        .expectStatusCode(201)
        .expectContentType(ContentType.JSON).build();
  }
  public static ResponseSpecification resNotFound(){
    return new ResponseSpecBuilder()
        .expectStatusCode(404)
        .expectContentType(ContentType.JSON).build();
  }

}
