package com.restapi.emp.repository;

import com.restapi.emp.model.Employee;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Map<Integer, Employee> empMap = new HashMap<>();

    @Override
    public void save(Employee employee) {
        empMap.put(employee.getId(), employee);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return Optional.ofNullable(empMap.get(id));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(empMap.values());
    }

    @Override
    public void deleteById(int id) {
        empMap.remove(id);
    }

    @Override
    public boolean existsById(int id) {
        return empMap.containsKey(id);
    }
}
