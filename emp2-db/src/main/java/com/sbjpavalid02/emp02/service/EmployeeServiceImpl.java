package com.restapi.emp.service;

import com.restapi.emp.model.Employee;
import com.restapi.emp.model.Gender;
import com.restapi.emp.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeServiceImpl service;

    private Employee emp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        emp = new Employee(1, "John Doe", "Developer", 5000, Gender.MALE, LocalDate.of(2022, 1, 1));
    }

    // ---------------- ADD EMPLOYEE ----------------
    @Test
    void addEmployee_Success() {
        when(repository.existsById(emp.getId())).thenReturn(false);

        boolean result = service.addEmployee(emp);

        assertTrue(result);
        verify(repository, times(1)).save(emp);
    }

    @Test
    void addEmployee_Fail_Duplicate() {
        when(repository.existsById(emp.getId())).thenReturn(true);

        boolean result = service.addEmployee(emp);

        assertFalse(result);
        verify(repository, never()).save(emp);
    }

    @Test
    void addEmployee_Fail_InvalidData() {
        Employee invalidEmp = new Employee(0, "", "", -100, null, LocalDate.now());

        boolean result = service.addEmployee(invalidEmp);

        assertFalse(result);
        verify(repository, never()).save(any());
    }

    // ---------------- UPDATE EMPLOYEE ----------------
    @Test
    void updateEmployee_Success() {
        when(repository.findById(emp.getId())).thenReturn(Optional.of(emp));

        boolean result = service.updateEmployee(emp.getId(), 6000, "Senior Developer");

        assertTrue(result);
        assertEquals(6000, emp.getSalary());
        assertEquals("Senior Developer", emp.getDesignation());
        verify(repository, times(1)).save(emp);
    }

    @Test
    void updateEmployee_Fail_InvalidSalaryOrDesignation() {
        boolean result = service.updateEmployee(emp.getId(), -10, "");
        assertFalse(result);
        verify(repository, never()).save(any());
    }

    @Test
    void updateEmployee_Fail_NotFound() {
        when(repository.findById(emp.getId())).thenReturn(Optional.empty());

        boolean result = service.updateEmployee(emp.getId(), 6000, "Senior Developer");
        assertFalse(result);
        verify(repository, never()).save(any());
    }

    // ---------------- DELETE EMPLOYEE ----------------
    @Test
    void deleteEmployee_Success() {
        when(repository.existsById(emp.getId())).thenReturn(true);

        boolean result = service.deleteEmployee(emp.getId());

        assertTrue(result);
        verify(repository, times(1)).deleteById(emp.getId());
    }

    @Test
    void deleteEmployee_Fail_NotFound() {
        when(repository.existsById(emp.getId())).thenReturn(false);

        boolean result = service.deleteEmployee(emp.getId());

        assertFalse(result);
        verify(repository, never()).deleteById(emp.getId());
    }

    // ---------------- GET EMPLOYEES ----------------
    @Test
    void getAllEmployees_ReturnsList() {
        List<Employee> list = List.of(emp);
        when(repository.findAll()).thenReturn(list);

        List<Employee> result = service.getAllEmployees();

        assertEquals(1, result.size());
        assertEquals(emp, result.get(0));
    }

    @Test
    void getEmployeeById_Found() {
        when(repository.findById(emp.getId())).thenReturn(Optional.of(emp));

        Optional<Employee> result = service.getEmployeeById(emp.getId());

        assertTrue(result.isPresent());
        assertEquals(emp, result.get());
    }

    @Test
    void getEmployeeById_NotFound() {
        when(repository.findById(emp.getId())).thenReturn(Optional.empty());

        Optional<Employee> result = service.getEmployeeById(emp.getId());

        assertTrue(result.isEmpty());
    }
}
