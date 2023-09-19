package org.example.tests;

import org.example.pojo.Album;
import org.example.pojo.Comment;
import org.example.pojo.Photo;
import org.example.pojo.ToDo;
import org.example.utilities.Utils;
import org.testng.Assert;

public class GetNestedResources {

  public void getPostComments(){
    Comment[] getPostComments= Utils.getPostReq(1)
        .when().get("/posts/{id}/comments")
        .then().spec(Utils.resOk()).extract().response().as(Comment[].class);
//    Check we have 5 comments
    Assert.assertEquals(getPostComments.length,5);
//    Verify fields of last comment
    Assert.assertEquals(getPostComments[4].getPostId(),1);
    Assert.assertEquals(getPostComments[4].getId(),5);
    Assert.assertEquals(getPostComments[4].getName(),"vero eaque aliquid doloribus et culpa");
    Assert.assertEquals(getPostComments[4].getEmail(),"Hayden@althea.biz");
    Assert.assertEquals(getPostComments[4].getBody(),"harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et");
  }

  public void getInvalidPostComments() {
    Comment[] getPostComments = Utils.getPostReq(101)
        .when().get("/posts/{id}/comments")
        .then().spec(Utils.resOk()).extract().response().as(Comment[].class);
    //    Check we have an empty array
    Assert.assertEquals(getPostComments.length,0);
  }

  public void getPostPhotos(){
    Photo[] getPhotos= Utils.getPostReq(2)
        .when().get("/albums/{id}/photos")
        .then().spec(Utils.resOk()).extract().response().as(Photo[].class);
    //    Check array is of correct length
    Assert.assertEquals(getPhotos.length,50);
//    Check random photo has correct fields
    Assert.assertEquals(getPhotos[36].getAlbumId(),2);
    Assert.assertEquals(getPhotos[36].getId(),87);
    Assert.assertEquals(getPhotos[36].getTitle(),"eos nihil sunt accusantium omnis");
    Assert.assertEquals(getPhotos[36].getUrl(),"https://via.placeholder.com/600/224566");
    Assert.assertEquals(getPhotos[36].getThumbnailUrl(),"https://via.placeholder.com/150/224566");
  }

  public void getUserAlbums(){
    Album[] getUserAlbums= Utils.getPostReq(5)
        .when().get("/users/{id}/albums")
        .then().spec(Utils.resOk()).extract().response().as(Album[].class);
    //    Check array is of correct length
    Assert.assertEquals(getUserAlbums.length,10);
    //    Check random album has correct fields
    Assert.assertEquals(getUserAlbums[4].getUserId(),5);
    Assert.assertEquals(getUserAlbums[4].getId(),45);
    Assert.assertEquals(getUserAlbums[4].getTitle(),"tenetur quos ea unde est enim corrupti qui");
  }

  public void getInvalidUserAlbums() {
    Album[] getInvalidUserAlbums = Utils.getPostReq(11)
        .when().get("/users/{id}/albums")
        .then().spec(Utils.resOk()).extract().response().as(Album[].class);
    //    Check array is empty
    Assert.assertEquals(getInvalidUserAlbums.length,0);
  }

  public void getUserToDos() {
    ToDo[] getUserToDos = Utils.getPostReq(3)
        .when().get("/users/{id}/todos")
        .then().spec(Utils.resOk()).extract().response().as(ToDo[].class);
    //    Check array is of correct length
    Assert.assertEquals(getUserToDos.length, 20);
    //    Check random todo has correct fields
    Assert.assertEquals(getUserToDos[7].getUserId(), 3);
    Assert.assertEquals(getUserToDos[7].getId(), 48);
    Assert.assertEquals(getUserToDos[7].getTitle(), "sit reprehenderit omnis quia");
    Assert.assertEquals(getUserToDos[7].getCompleted(), "false");
  }

    public void getInvalidUserToDos() {
      Album[] getInvalidUserToDos = Utils.getPostReq(11)
          .when().get("/users/{id}/todos")
          .then().spec(Utils.resOk()).extract().response().as(Album[].class);
      //    Check array is empty
      Assert.assertEquals(getInvalidUserToDos.length,0);
    }



  }

