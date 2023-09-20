package resources;

public enum Api {

  allPosts("/posts"),
  post1 ("/posts/1"),
  postComments("/posts/{id}/comments"),
  albumPhotos("/albums/{id}/photos"),
  userAlbums("/users/{id}/albums"),
  userTodos("/users/{id}/todos");
  private String resource;
  Api(String resource){
    this.resource=resource;
  }
  public String getResource(){
    return resource;
  }
}
