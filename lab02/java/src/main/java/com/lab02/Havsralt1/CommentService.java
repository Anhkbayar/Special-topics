package com.lab02.Havsralt1;

public class CommentService {
    public void editComment(long commentId, Long userId, String newText){
        Comment comment = commentRepository.findById(commentId);

        User currentUser = userRepository.findById(userId);
        boolean isAdmin = currentUser.getRole().equals("ADMIN");
        boolean isOwner = currentUser.getRole().equals(userId);

        if(!isAdmin && !isOwner){
            throw new UnauthorizedException("Cannot edit this comment");
        }

        comment.setText(newText);
        commentRepository.save(comment);
    }
}
