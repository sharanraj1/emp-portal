package com.sg.employeeportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.sg.employeeportal.model.Employee;
import com.sg.employeeportal.repository.EmployeeRepository;

@Service(value="employeeService")
public class EmployeeServiceImpl implements EmployeeService {
  
  @Autowired
  private EmployeeRepository employeeRepository;
  
  @Override
  public List<Employee> findAll(){
      return (List<Employee>) employeeRepository.findAll();
  }
  
  @Override
  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

}
