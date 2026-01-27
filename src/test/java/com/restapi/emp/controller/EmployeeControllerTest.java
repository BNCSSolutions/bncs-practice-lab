package com.restapi.emp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.restapi.emp.model.Employee;
import com.restapi.emp.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

  
    // ✅ Test: Get All Employees
    @Test
    void getAllEmployees_success() throws Exception {
        when(service.getAllEmployees()).thenReturn(List.of(new Employee()));

        mockMvc.perform(get("/api/employees/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    // ✅ Test: Get Employee By ID
    @Test
    void getEmployeeById_success() throws Exception {
        when(service.getEmployeeById(1)).thenReturn(new Employee());

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk());
    }
}
