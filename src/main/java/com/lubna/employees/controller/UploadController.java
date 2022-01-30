package com.lubna.employees.controller;

import com.lubna.employees.model.Employee;
import com.lubna.employees.model.EmployeeWorkTogether;
import com.lubna.employees.services.Parser;
import com.lubna.employees.services.ProcessEmployees;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UploadController {

    private Parser parser;
    private ProcessEmployees process;

    public UploadController(Parser parser, ProcessEmployees process) {
        this.parser = parser;
        this.process = process;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload-csv-file")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
        } else {
            try {
                List<Employee> employees = parser.parseFile(file);
                List<EmployeeWorkTogether> employeeWorkTogethers = process.processEmployees(employees);
                // save employees list on model
                model.addAttribute("employeeWorkTogethers", employeeWorkTogethers);
                model.addAttribute("status", true);

            } catch (Exception e) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);

                e.printStackTrace();
            }
        }
        return "employees-statistics";
    }
}
