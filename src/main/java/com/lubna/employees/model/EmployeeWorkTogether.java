package com.lubna.employees.model;

import java.util.Objects;

public class EmployeeWorkTogether {

    private String employeeId1;
    private String employeeId2;
    private String projectId;
    private int daysWorked;


    public EmployeeWorkTogether() {
    }

    public EmployeeWorkTogether(String employeeId1, String employeeId2, String projectId, int daysWorked) {
        this.employeeId1 = employeeId1;
        this.employeeId2 = employeeId2;
        this.projectId = projectId;
        this.daysWorked = daysWorked;
    }

    public String getEmployeeId1() {
        return employeeId1;
    }

    public void setEmployeeId1(String employeeId1) {
        this.employeeId1 = employeeId1;
    }

    public String getEmployeeId2() {
        return employeeId2;
    }

    public void setEmployeeId2(String employeeId2) {
        this.employeeId2 = employeeId2;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeWorkTogether that = (EmployeeWorkTogether) o;
        return daysWorked == that.daysWorked && Objects.equals(employeeId1, that.employeeId1) && Objects.equals(employeeId2, that.employeeId2) && Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId1, employeeId2, projectId, daysWorked);
    }

    @Override
    public String toString() {
        return "EmployeeWorkTogether{" +
                "employeeId1='" + employeeId1 + '\'' +
                ", employeeId2='" + employeeId2 + '\'' +
                ", projectId='" + projectId + '\'' +
                ", daysWorked=" + daysWorked +
                '}';
    }
}
