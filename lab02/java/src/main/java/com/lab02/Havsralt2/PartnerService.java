package com.lab02.Havsralt2;

import com.lab02.Havsralt2.Validator.EmailValidation;

public class PartnerService {

  private final partnerRepository partnerRepository;

  public void addPartner(String companyEmail, String companyName) {
    EmailValidation.validate(companyEmail);

    Partner partner = new Partner(companyEmail, companyName);
    partnerRepository.save(partner);
  }
}
