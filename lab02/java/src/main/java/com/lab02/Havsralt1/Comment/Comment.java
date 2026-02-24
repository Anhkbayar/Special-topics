package com.lab02.Havsralt1.Comment;

import com.lab02.Havsralt1.Security.OwnerInterface;

public class Comment implements OwnerInterface {
    private Long authorId;

    @Override
    public Long getAuthorId(){
        return authorId;
    }
}
