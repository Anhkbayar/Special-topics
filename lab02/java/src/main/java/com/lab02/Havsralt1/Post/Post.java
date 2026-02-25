package com.lab02.Havsralt1.Post;

import com.lab02.Havsralt1.Security.OwnerInterface;

public class Post implements OwnerInterface {
  private Long authorId;

  @Override
  public Long getAuthorId() {
    return authorId;
  }
}
