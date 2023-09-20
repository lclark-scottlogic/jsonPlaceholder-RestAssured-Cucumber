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
  public static RequestSpecification req;
  public RequestSpecification baseReq() {
//    try/catch for case that no such logging file exists

    if (req == null) {
      PrintStream log = null;
      try {
        log = new PrintStream(new FileOutputStream("logging.txt"));
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }

      req = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com")
          .setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log))
          .addFilter(
              ResponseLoggingFilter.logResponseTo(log)).build();
      return req;
    }return req;
  }
  public RequestSpecification createPostReq(Post post){
    return given().spec(baseReq()).body(post);
  }
  public RequestSpecification getPostReq(int id){
    return given().spec(baseReq()).pathParam("id",id);
  }
  public RequestSpecification getAllPostReq(){
    return given().spec(baseReq());
  }
  public RequestSpecification deletePostReq(int id){
    return given().spec(baseReq()).pathParam("id",id);
  }
  public RequestSpecification getPostByUserReq(int id){
    return given().spec(baseReq()).queryParam("userId",id);
  }
  public RequestSpecification patchPostReq(String Json,int id){
    return given().spec(baseReq()).body(Json).pathParam("id",id);
  }

  public ResponseSpecification resOk(){
    return new ResponseSpecBuilder()
        .expectStatusCode(200)
        .expectContentType(ContentType.JSON).build();
  }
  public ResponseSpecification resCreated(){
    return new ResponseSpecBuilder()
        .expectStatusCode(201)
        .expectContentType(ContentType.JSON).build();
  }
  public ResponseSpecification resNotFound(){
    return new ResponseSpecBuilder()
        .expectStatusCode(404)
        .expectContentType(ContentType.JSON).build();
  }

}
