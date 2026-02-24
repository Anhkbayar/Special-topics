package com.lab02.Havsralt1.Security;

public class AuthorizationService {
    public void checkOwnershipOrAdmin(User user, OwnerInterface resource){
        boolean isAdmin = "ADMIN".equals(user.getRole());
        boolean isOwner = resource.getAuthorId().equals(user.getId());

        if(!isAdmin && !isOwner){
            throw new UnauthorizedException("Unauthorized action");
        }
    }
}