package com.prash.crud_operation.service;

import com.prash.crud_operation.entity.Employee;
import com.prash.crud_operation.repo.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee saveEmployee(Employee employee) {
        if (repository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setAge(employeeDetails.getAge());
        employee.setDepartment(employeeDetails.getDepartment());
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
