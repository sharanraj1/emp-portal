package com.sg.employeeportal.repository;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sg.employeeportal.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
  
  @Autowired
  private EmployeeRepository employeeRepository;
  
  @Test
  public void testFindAll() {
      testSave();
      List<Employee> items = (List<Employee>) employeeRepository.findAll();
      assertEquals(1, items.size());
  }

  @Test
  public void testSave() {
      Employee testEmployee = new Employee(101L, "Bill", "Rhodes", "Male", new Date(), "Design");
      Employee employee = employeeRepository.save(testEmployee);
      assertEquals(testEmployee.getFirstName(),employee.getFirstName());
  }
  
}
