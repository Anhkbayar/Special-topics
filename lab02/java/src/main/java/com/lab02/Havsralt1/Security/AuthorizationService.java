package com.lab02.Havsralt1.Security;

import java.util.List;

public class AuthorizationService {
  private final List<AuthRule> rules;

  public AuthorizationService(List<AuthRule> rules) {
    this.rules = rules;
  }

  public void checkOwnershipOrAdmin(User user, OwnerInterface resource) {
    boolean isAuthorized = rules.stream().anyMatch(rule -> rule.isAuthorized(user, resource));

    if (!isAuthorized) {
      throw new UnauthorizedException("Unauthorized action");
    }
  }
}
