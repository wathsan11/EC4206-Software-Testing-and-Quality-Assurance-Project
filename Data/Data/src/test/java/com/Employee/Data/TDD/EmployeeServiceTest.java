package com.Employee.Data.TDD;

import com.Employee.Data.Employee;
import com.Employee.Data.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    @BeforeEach
    public void beforeEach()
    {
        System.out.println("Test started");
    }
    @AfterEach
    public void afterEach()
    {
        System.out.println("Test complied");
    }

    @Test
    public void getEmployeeById()
    {
        EmployeeService employeeService = new EmployeeService();
        Employee employee1 = new Employee(1,"John","johncena@gmail.com");
        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Brock");
        employee2.setEmail("brocklesner@gmail.com");

        employeeService.addEmployee(employee1);
        assertEquals(employee1,employeeService.getEmployeeById(1));

        employeeService.addEmployee(employee2);
        assertEquals(employee2,employeeService.getEmployeeById(2));

        assertNull(employeeService.getEmployeeById(50));

    }

    @Test
    public void addEmployeeTest()
    {
        var employeeService1= new EmployeeService();
        var employee1= new Employee(1,"Harry","harrypotter@gmail.com");
        var employee2= new Employee(10,"Leo","leomessi@gmail.com");


        employeeService1.addEmployee(employee1);
        assertNotNull(employeeService1.getEmployeeById(1));
        assertEquals(employee1,employeeService1.getEmployeeById(1));

        Employee employee3 = new Employee();

        employee3.setName("Ben");
        employee3.setEmail("bentenision@gmail.com");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeService1.addEmployee(employee3);
        });
        assertEquals("Invalid employee Id", exception.getMessage());

        var employee7= new Employee(7,"Bekham","davidbekham@gmail.com");
        var employeeCR7= new Employee(7,"Ronaldo","CR7@gmail.com");

        employeeService1.addEmployee(employee7);
        assertEquals(employee7,employeeService1.getEmployeeById(7));

        Exception exceptionCR7 = assertThrows(IllegalArgumentException.class, () ->{
            employeeService1.addEmployee(employeeCR7);
        });
        assertEquals("Employee with same Id already exists",exceptionCR7.getMessage());


    }

    @Test
    public void employeeDeleteTest()
    {
        var employeeService = new EmployeeService();
        var employee1 = new Employee(1,"ken","kenmayers@gmail.com");
        employeeService.addEmployee(employee1);
        var employee2 = new Employee(2,"will","willturner@gmail.com");
        employeeService.addEmployee(employee2);

        employeeService.deleteEmployeeById(employee1.getId());
        assertNull(employeeService.getEmployeeById(1));
        assertEquals(employee2,employeeService.getEmployeeById(2));

        Exception exception2 =assertThrows(IllegalArgumentException.class,()->{
            employeeService.deleteEmployeeById(3);
        });
        assertEquals("Employee not found",exception2.getMessage());

    }

}
