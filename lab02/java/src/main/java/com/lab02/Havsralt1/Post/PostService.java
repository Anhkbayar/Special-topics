package com.lab02.Havsralt1.Post;

import com.lab02.Havsralt1.Security.AuthorizationService;

public class PostService {
  public void deletePost(long PostId, long UserId) {
    Post post = postRepository.findById(PostId);
    User user = userRepository.findById(UserId);

    AuthorizationService.checkOwnershipOrAdmin(user, post);

    postRepository.delete(post);
  }
}
