package com.lubna.employees.model;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Date;
import java.util.Objects;

public class Employee {

    @CsvBindByPosition(position = 0)
    private String employeeID;
    @CsvBindByPosition(position = 1)
    private String projectID;
    @CsvBindByPosition(position = 2)
    private String dateFrom;
    @CsvBindByPosition(position = 3)
    private String DateTo;

    Date dateFromD;
    Date dateToD;

    public Employee() {
    }

    public Employee(String employeeID, String projectID, String dateFrom, String dateTo) {
        this.employeeID = employeeID;
        this.projectID = projectID;
        this.dateFrom = dateFrom;
        DateTo = dateTo;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return DateTo;
    }

    public void setDateTo(String dateTo) {
        DateTo = dateTo;
    }

    public Date getDateFromD() {
        return dateFromD;
    }

    public void setDateFromD(Date dateFromD) {
        this.dateFromD = dateFromD;
    }

    public Date getDateToD() {
        return dateToD;
    }

    public void setDateToD(Date dateToD) {
        this.dateToD = dateToD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getEmployeeID(), employee.getEmployeeID()) && Objects.equals(getProjectID(), employee.getProjectID()) && Objects.equals(getDateFrom(), employee.getDateFrom()) && Objects.equals(getDateTo(), employee.getDateTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeID(), getProjectID(), getDateFrom(), getDateTo());
    }

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", projectID=" + projectID + ", dateFrom=" + dateFrom
				+ ", DateTo=" + DateTo + ", dateFromD=" + dateFromD + ", dateToD=" + dateToD + "]";
	}


}
