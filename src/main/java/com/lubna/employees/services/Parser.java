package com.lubna.employees.services;

import com.lubna.employees.model.Employee;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;

@Service
public class Parser {
    public List<Employee> parseFile(MultipartFile inputFile) throws Exception{

        // parse CSV file to create a list of `Employee` objects
        Reader reader = new BufferedReader(new InputStreamReader(inputFile.getInputStream()));

        // create csv bean reader
        CsvToBean<Employee> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Employee.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

        // convert `CsvToBean` object to list of Employee
        List<Employee> employees = csvToBean.parse();

        return employees;
    }
}

