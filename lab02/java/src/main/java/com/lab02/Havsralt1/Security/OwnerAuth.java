package com.lab02.Havsralt1.Security;

public class OwnerAuth implements AuthRule {
    @Override
    public boolean isAuthorized(User user, OwnerInterface resource){
        return resource.getAuthorId().equals(user.getId());
    }
}
