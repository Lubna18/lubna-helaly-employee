package com.lubna.employees.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

    private Employee e;

    @Before
    public void init(){
        e = new Employee("567","77","2011-04-22","2022-06-29");
    }

    @Test
    public void SetterAndGetters_Success() {
        Assert.assertNotNull(e);
        Assert.assertEquals(e.getEmployeeID(),"567");
        Assert.assertEquals(e.getProjectID(),"77");
    }
}
