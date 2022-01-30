package com.lubna.employees.services;

import com.lubna.employees.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ParserTest {

	@InjectMocks
    private Parser parser;

    @Test
    public void parseFileTest() throws Exception {
        Path path = Paths.get("src/test/resources/test1.csv");
        MockMultipartFile multipartFile
                = new MockMultipartFile(
                "file",
                "src/test/resources/test1.csv",
                MediaType.TEXT_PLAIN_VALUE,
                Files.readAllBytes(path)
        );

        List<Employee> employeeList = parser.parseFile(multipartFile);

        Assert.assertNotNull(employeeList);
        Assert.assertEquals(employeeList.size(),4);
    }
}
