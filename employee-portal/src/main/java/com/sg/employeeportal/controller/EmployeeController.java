package com.sg.employeeportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import javax.validation.Valid;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.sg.employeeportal.service.EmployeeService;
import com.sg.employeeportal.model.Employee;
import com.sg.employeeportal.dto.ResponseDTO;

@RestController
@RequestMapping("/api")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @ApiOperation(value = "Get all details of employees", response = List.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Employee details loaded..", response = List.class),
      @ApiResponse(code = 500, message = "Internal Server Error")})
  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return employeeService.findAll();
  }

  @ApiOperation(value = "Register a new Employee", response = Employee.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Employee Registered successfully", response = Employee.class),
      @ApiResponse(code = 400, message = "Invalid Details"),
      @ApiResponse(code = 500, message = "Internal Server Error")})
  @PostMapping("/employees")
  public ResponseEntity<ResponseDTO> registerNewEmployee(@Valid @RequestBody Employee employee, UriComponentsBuilder uriBuilder) {
    Employee newEmployee = employeeService.save(employee);
    UriComponents uriComponents = uriBuilder.path("/employees/{id}").buildAndExpand(newEmployee.getEmployeeId());
    ResponseEntity<ResponseDTO> response =
        ResponseEntity.created(uriComponents.toUri()).body(new ResponseDTO("v1", true, newEmployee));

    return response;
  }

}
