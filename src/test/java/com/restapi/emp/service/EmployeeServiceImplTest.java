package com.restapi.emp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.restapi.emp.model.Employee;
import com.restapi.emp.model.Gender;
import com.restapi.emp.repository.EmployeeRepository;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository repo;

    @InjectMocks
    private EmployeeServiceImpl service;

    private Employee employee;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        employee = new Employee();
        employee.setEmployeeId("EMP001");
        employee.setName("John Doe");
        employee.setEmail("john@gmail.com");
        employee.setMobile("9876543210");
        employee.setDesignation("Developer");
        employee.setSalary(50000);
        employee.setGender(Gender.MALE);
        employee.setDoj(LocalDate.now());
    }

    // ✅ Test 1: Add Employee - Success
    @Test
    void addEmployee_success() {
        when(repo.existsByEmployeeIdOrEmail("EMP001", "john@gmail.com"))
                .thenReturn(false);
        when(repo.save(employee)).thenReturn(employee);

        Employee saved = service.addEmployee(employee);

        assertNotNull(saved);
        assertEquals("John Doe", saved.getName());
        verify(repo, times(1)).save(employee);
    }

    // ❌ Test 2: Add Employee - Already Exists
    @Test
    void addEmployee_alreadyExists() {
        when(repo.existsByEmployeeIdOrEmail("EMP001", "john@gmail.com"))
                .thenReturn(true);

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> service.addEmployee(employee));

        assertEquals("Employee already exists", ex.getMessage());
    }

    // ✅ Test 3: Update Employee
    @Test
    void updateEmployee_success() {
        when(repo.findById(1)).thenReturn(Optional.of(employee));
        when(repo.save(any(Employee.class))).thenReturn(employee);

        Employee updated = service.updateEmployee(1, "Manager", 80000, "new@gmail.com");

        assertEquals("Manager", updated.getDesignation());
        assertEquals(80000, updated.getSalary());
        assertEquals("new@gmail.com", updated.getEmail());
    }

    // ❌ Test 4: Update Employee - Not Found
    @Test
    void updateEmployee_notFound() {
        when(repo.findById(1)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> service.updateEmployee(1, "HR", 40000, "hr@gmail.com"));
    }

    // ✅ Test 5: Delete Employee
    @Test
    void deleteEmployee_success() {
        when(repo.existsById(1)).thenReturn(true);
        doNothing().when(repo).deleteById(1);

        boolean result = service.deleteEmployee(1);

        assertTrue(result);
        verify(repo, times(1)).deleteById(1);
    }

    // ❌ Test 6: Delete Employee - Not Found
    @Test
    void deleteEmployee_notFound() {
        when(repo.existsById(1)).thenReturn(false);

        assertThrows(RuntimeException.class,
                () -> service.deleteEmployee(1));
    }

    // ✅ Test 7: Get All Employees
    @Test
    void getAllEmployees_success() {
        when(repo.findAll()).thenReturn(List.of(employee));

        List<Employee> list = service.getAllEmployees();

        assertEquals(1, list.size());
    }
}
