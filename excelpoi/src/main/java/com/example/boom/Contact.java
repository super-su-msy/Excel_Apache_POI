package com.example.boom;

import java.math.BigDecimal;

public class Contact {

  public String firstName;
  public String lastName;
  public String email;
  public String dateOfBirth;
  public BigDecimal hellyeah;

  public Contact(String firstName, String lastName, String email,
    String dateOfBirth,  BigDecimal hellyeah) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.hellyeah = hellyeah;
  }

}