package com.lab02.Havsralt1.Comment;

import com.lab02.Havsralt1.Security.AuthorizationService;

public class CommentService {
  public void editComment(long commentId, Long userId, String newText) {
    Comment comment = commentRepository.findById(commentId);
    User user = userRepository.findById(userId);

    AuthorizationService.checkOwnershipOrAdmin(user, comment);

    comment.setText(newText);
    commentRepository.save(comment);
  }
}
