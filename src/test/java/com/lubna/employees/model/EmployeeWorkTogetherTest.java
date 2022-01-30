package com.lubna.employees.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeWorkTogetherTest {

    private EmployeeWorkTogether employeeWorkTogether;

    @Before
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
