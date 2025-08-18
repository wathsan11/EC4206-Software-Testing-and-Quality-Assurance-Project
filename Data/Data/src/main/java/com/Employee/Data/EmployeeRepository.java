package com.Employee.Data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    boolean existsByEmail(String email);
}
