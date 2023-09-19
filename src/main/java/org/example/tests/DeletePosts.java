package org.example.tests;

import org.example.utilities.Utils;

public class DeletePosts {

  public void deletePost(){
    Utils.deletePostReq(1)
        .when().delete("/posts/{id}")
        .then().spec(Utils.resOk());
  }
}
