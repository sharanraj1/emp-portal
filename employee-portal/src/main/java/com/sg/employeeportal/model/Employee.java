package com.sg.employeeportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long employeeId;

  @NotBlank(message = "First Name is required")
  private String firstName;

  @NotBlank(message = "Last Name is required")
  private String lastName;

  @NotBlank(message = "Gender is required")
  private String gender;

  @NotNull(message = "Date of Birth is required")
  private Date dob;

  @NotBlank(message = "Department is required")
  private String department;

  public Employee(Long employeeId, String firstName, String lastName, String gender, Date dob, String department) {
    this.employeeId = employeeId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.dob = dob;
    this.department = department;
  }

  public Employee() {
    
  }

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

}
