package com.lab02.Havsralt1.Security;

public class AdminAuth implements AuthRule {
    @Override
    public boolean isAuthorized(User user, OwnerInterface resource){
        return "ADMIN".equals(user.getRole());
    }
}
