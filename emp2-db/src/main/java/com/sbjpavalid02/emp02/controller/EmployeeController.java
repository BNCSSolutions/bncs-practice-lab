package com.restapi.emp.controller;

import com.restapi.emp.model.Employee;
import com.restapi.emp.model.Gender;
import com.restapi.emp.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void addEmployee_ReturnsSuccess() throws Exception {
        Employee emp = new Employee(1, "John Doe", "Developer", 5000, Gender.MALE, LocalDate.now());

        when(service.addEmployee(any())).thenReturn(true);

        mockMvc.perform(post("/employee/addEmp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(emp)))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee added"));

        verify(service, times(1)).addEmployee(any());
    }

    @Test
    void getAllEmployees_ReturnsList() throws Exception {
        Employee emp = new Employee(1, "John Doe", "Developer", 5000, Gender.MALE, LocalDate.now());
        when(service.getAllEmployees()).thenReturn(List.of(emp));

        mockMvc.perform(get("/employee/getEmp"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"));
    }

    @Test
    void getEmployeeById_Found() throws Exception {
        Employee emp = new Employee(1, "John Doe", "Developer", 5000, Gender.MALE, LocalDate.now());
        when(service.getEmployeeById(1)).thenReturn(Optional.of(emp));

        mockMvc.perform(get("/employee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    void updateEmployee_ReturnsSuccess() throws Exception {
        when(service.updateEmployee(1, 6000, "Senior Dev")).thenReturn(true);

        mockMvc.perform(put("/employee/1")
                        .param("salary", "6000")
                        .param("designation", "Senior Dev"))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee updated"));
    }

    @Test
    void deleteEmployee_ReturnsSuccess() throws Exception {
        when(service.deleteEmployee(1)).thenReturn(true);

        mockMvc.perform(delete("/employee/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee deleted"));
    }
}
