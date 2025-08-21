package com.Employee.Data.BDD;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;

import com.Employee.Data.DataApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

@CucumberContextConfiguration
@SpringBootTest
@RunWith(Cucumber.class)
public class CucumberEmployeeRunner {
}
