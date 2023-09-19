package org.example.pojo;

import java.util.Objects;

public class Post {
  private int id;
  private String title;
  private String body;
  private int userId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
  public String getJsonString(String json){
    if(Objects.equals(json, "body")){
      return this.getBody();
    } else if (Objects.equals(json, "title")) {
      return this.getTitle();
    }
  return json;
  }

  public int getJsonInt(String json) {
    if(Objects.equals(json, "id")){
      return this.getId();
    } else if (Objects.equals(json, "userId")) {
      return this.getUserId();
    }
    return 0;
  }
}
