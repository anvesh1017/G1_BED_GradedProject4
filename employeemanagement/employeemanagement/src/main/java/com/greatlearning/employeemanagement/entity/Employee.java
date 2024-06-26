package com.greatlearning.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "email")
  private String email;


  public Employee() {

  }

  public Employee(String firstName, String lastName, String email) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}  
