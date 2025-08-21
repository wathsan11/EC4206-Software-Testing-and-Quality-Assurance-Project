package com.Employee.Data.BDD;

import com.Employee.Data.Employee;
import com.Employee.Data.EmployeeService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Cucumber.class)
public class EmployeeStepDef {

    private EmployeeService empService;
    private Employee employee;
    private Employee result;

    @Before
    public void setup(){
        empService =new EmployeeService();
    }

    @Given("an employee with id {int} and name {string} and gmail {string}")
    public void create_an_employee(int id, String name, String gmail){
        employee = new Employee(id,name,gmail);
    }

    @When("I add the employee")
    public void add_the_employee(){
        empService.addEmployee(employee);
    }

    @When("I search employee with id {int}")
    public void search_employee(int id) {
        empService.addEmployee(employee);
        result = empService.getEmployeeById(id);
    }

    @When("I delete employee with id {int}")
    public void delete_employee_by_id(int id){
        empService.addEmployee(employee);
        empService.deleteEmployeeById(id);
    }

    @Then("the employee with id {int} should exist")
    public void employee_exists_by_id(int id){
        result = empService.getEmployeeById(id);
        assertEquals(employee,result);
    }

    @Then("I should get employee with name {string}")
    public void get_employee_by_id(String name){
        assertEquals(result.getName(),name);
    }

    @Then("searching for employee with id {int} should return null")
    public void verify_deleted_employee(int id){
        assertNull(empService.getEmployeeById(id));
    }

}
