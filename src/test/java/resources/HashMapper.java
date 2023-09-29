package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapper {
public HashMap createPostHash(String caseName) throws IOException {
  DataDriven driver = new DataDriven();
  ArrayList data=driver.getData("createPost",caseName);
  HashMap<String,Object> map=new HashMap<>();
  map.put("id",data.get(0));
  map.put("title",data.get(1));
  map.put("body",data.get(2));
  map.put("userId",data.get(3));

  return map;
}
  public HashMap updatePostHash(String caseName,String field) throws IOException {
    DataDriven driver = new DataDriven();
    ArrayList data=driver.getData("updatePost",caseName);
    HashMap<String,Object> map=new HashMap<>();
    switch(field){
      case "title":
        map.put("title",data.get(1));
        break;
      case "body":
        map.put("body",data.get(2));
        break;
      case "id":
        map.put("id",data.get(0));
        break;
      case "userId":
        map.put("userId",data.get(3));
        break;
      default:
        throw new RuntimeException("invalid field");
    }
    return map;
  }

}
