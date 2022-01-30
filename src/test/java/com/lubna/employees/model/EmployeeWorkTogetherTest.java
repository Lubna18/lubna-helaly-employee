package com.lubna.employees.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeWorkTogetherTest {

    private EmployeeWorkTogether employeeWorkTogether;

    @BeforeEach
    public void init(){
        employeeWorkTogether = new EmployeeWorkTogether("55","66","1", 9);
    }

    @Test
    public void SetterAndGetters_Success() {
        Assert.assertNotNull(employeeWorkTogether);
        Assert.assertEquals(employeeWorkTogether.getDaysWorked(), 9);
        Assert.assertEquals(employeeWorkTogether.getProjectId(), "1");
    }
}
