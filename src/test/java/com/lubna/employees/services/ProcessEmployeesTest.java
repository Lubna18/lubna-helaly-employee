package com.lubna.employees.services;

import com.lubna.employees.model.Employee;
import com.lubna.employees.model.EmployeeWorkTogether;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProcessEmployeesTest {

    @InjectMocks
    ProcessEmployees processEmployees;

    @Test
    public void processEmployeesTestSuccess(){
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee( "143","10","2009-01-01","2011-04-27");
        employees.add(employee);
        Employee employee1 = new Employee("218","10","2011-04-20","NULL");
        employees.add(employee1);
        List<EmployeeWorkTogether> employeeWorkTogethers =  processEmployees.processEmployees(employees);

        Assert.assertNotNull(employeeWorkTogethers);
        Assert.assertEquals(employeeWorkTogethers.size(),1);
    }

    @Test
    public void processEmployeesTestEmpty(){
        List<Employee> employees = new ArrayList<>();
        List<EmployeeWorkTogether> employeeWorkTogethers =  processEmployees.processEmployees(employees);

        Assert.assertEquals(employeeWorkTogethers.size(),0);
    }
}
