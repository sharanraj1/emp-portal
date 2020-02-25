package com.sg.employeeportal.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.sg.employeeportal.model.Employee;
import com.sg.employeeportal.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

  @Autowired
  private EmployeeService employeeService;

  @MockBean
  private EmployeeRepository employeeRepository;
  
  @Before
  public void setup() {
    when(employeeRepository.findAll()).thenReturn(Arrays.asList(new Employee(101L, "Bill", "Rhodes", "Male", new Date(), "Design"),
    new Employee(102L, "Sharan", "Raj", "Male", new Date(), "Development")));
    
    when(employeeRepository.save(Mockito.any())).thenReturn(new Employee(101L, "Bill", "Rhodes", "Male", new Date(), "Design"));
  }
  
  @Test
  public void findAllTest() {     
      List<Employee> employees = employeeService.findAll();
      assertEquals(new Long(101), employees.get(0).getEmployeeId());      
  }
  
  @Test
  public void saveTest() {     
    Employee testEmployee=new Employee(101L, "Bill", "Rhodes", "Male", new Date(), "Design");
    Employee employee= employeeService.save(testEmployee);
    assertEquals(testEmployee.getEmployeeId(), employee.getEmployeeId());      
  }
  
}
