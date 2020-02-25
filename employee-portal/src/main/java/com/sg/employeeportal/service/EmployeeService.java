package com.sg.employeeportal.service;

import java.util.List;
import com.sg.employeeportal.model.Employee;

public interface EmployeeService {
  public List<Employee> findAll();
  public Employee save(Employee employee);
}
