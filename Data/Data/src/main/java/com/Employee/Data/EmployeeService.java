package com.Employee.Data;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private List<Employee> empDataRepo = new ArrayList<>();

    public void addEmployee(Employee emp)
    {
        if (emp == null || emp.getId() <= 0)
        {
            throw new IllegalArgumentException("Invalid employee Id");
        }

        boolean exists = empDataRepo.stream().anyMatch(e->e.getId() == emp.getId());
        if(exists)
        {
            throw new IllegalArgumentException("Employee with same Id already exists");
        }
         empDataRepo.add(emp);
    }
    public Employee getEmployeeById(int id)
    {
        return empDataRepo.stream()
                .filter(e ->e.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public void deleteEmployeeById(int Id)
    {
        boolean removed = empDataRepo.removeIf(e->e.getId()==Id);
        if(!removed)
        {
            throw new IllegalArgumentException("Employee not found");
        }

//        boolean exists = empDataRepo.stream().anyMatch(e->e.getId()==Id);
//        if(exists)
//        {
//            empDataRepo.removeIf(e->e.getId()==Id);
//        }
//        else {
//            throw new IllegalArgumentException("Id is not found");
//        }
    }


}
