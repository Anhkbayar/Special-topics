package com.lab02.Havsralt2.Validator;

public final class EmailValidation {
  private EmailValidation() {}
  ;

  public static void validate(String email) {
    if (!email.contains("@")) {
      throw new InvalidEmailException("Email must contain @");
    }
    if (email.length() < 5) {
      throw new InvalidEmailException("Email too short");
    }
    if (email.length() > 50) {
      throw new InvalidEmailException("Email too long");
    }
  }
}
