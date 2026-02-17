package com.lab02.Havsralt1;

public class PostService {
    public void deletePost(long PostId, long UserId){
        Post post = postRepository.findById(PostId);

        User user = userRepository.findById(UserId);
        if(user.getRole().equals("ADMIN")){
            postRepository.delete(post);
            return;
        }

        if(post.getAuthorId().equals(UserId)){
            postRepository.delete(post);
            return;
        }

        throw new UnauthorizedException("Cannot delete this post");
    }
}
