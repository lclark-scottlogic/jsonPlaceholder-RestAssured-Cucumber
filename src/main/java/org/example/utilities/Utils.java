package org.example.utilities;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.pojo.Post;

public class Utils {

  public static RequestSpecification baseReq() {
    return new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com")
        .setContentType(ContentType.JSON).build();
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