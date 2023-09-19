package org.example.tests;

import org.example.utilities.Utils;
import org.example.utilities.ResSpecBuilders;

public class DeletePosts {

  public void deletePost(){
    Utils.deletePostReq(1)
        .when().delete("/posts/{id}")
        .then().spec(Utils.resOk());
  }
}
