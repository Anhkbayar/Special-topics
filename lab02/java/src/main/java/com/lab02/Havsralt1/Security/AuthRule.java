package com.lab02.Havsralt1.Security;

public interface AuthRule {
    boolean isAuthorized(User user, OwnerInterface resource);
}
