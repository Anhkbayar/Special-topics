package com.lab02.Havsralt2;

import com.lab02.Havsralt2.Validator.EmailValidation;

public class UserRegistrationService {
  private userRepository userRepository;

  public void registerUser(String email, String password) {
    EmailValidation.validate(email);

    User user = new User(email, password);
    userRepository.save(user);
  }
}
