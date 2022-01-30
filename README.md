#Application Guide
##Employees Task
An application that identifies the pair of employees who have worked together on
common projects for the longest period of time.

Input Data:
A CSV file with data in the following format:
EmpID, ProjectID, DateFrom, DateTo

Sample data:
143, 12, 2013-11-01, 2014-01-05

###Technologies
Backend: Java 11 ,Spring Boot 2.6.3, Maven, Junit
Frontend: Thymeleaf,HTML, bootstrap

###Build
mvn clean install -Dmaven.test.skip=true

###Run
From IDE, Run class "EmployeesApplication"
Open in browser http://localhost:8080/