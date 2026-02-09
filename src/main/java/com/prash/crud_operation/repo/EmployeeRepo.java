package com.prash.crud_operation.repo;

import com.prash.crud_operation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    boolean existsByEmail(String email);

}
