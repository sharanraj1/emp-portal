package com.sg.employeeportal.repository;

import org.springframework.data.repository.CrudRepository;
import com.sg.employeeportal.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
