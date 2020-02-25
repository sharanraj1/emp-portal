package com.sg.employeeportal.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.employeeportal.model.Employee;
import com.sg.employeeportal.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private EmployeeRepository employeeRepository;

  @Before
  public void setup() {
    JacksonTester.initFields(this, new ObjectMapper());
    when(employeeRepository.findAll())
        .thenReturn(Arrays.asList(new Employee(101L, "Bill", "Rhodes", "Male", new Date(), "Design"),
            new Employee(102L, "Sharan", "Raj", "Male", new Date(), "Development")));

    when(employeeRepository.save(Mockito.any()))
        .thenReturn(new Employee(101L, "Bill", "Rhodes", "Male", new Date(), "Design"));
  }

  @Test
  public void findAllTest() throws Exception {
   
      mvc.perform(get("/api/employees").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());       

  }

  @Test
  public void saveTest() throws Exception {
    Employee testEmployee = new Employee(101L, "Bill", "Rhodes", "Male", new Date(), "Design");

    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(testEmployee);

    mvc.perform(post("/api/employees").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isCreated())
        .andExpect(header().string("location", "http://localhost/employees/101"));
  }
}
