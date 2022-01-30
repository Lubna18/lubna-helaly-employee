package com.lubna.employees.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UploadControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void whenFileUploaded_thenVerifyStatus()
            throws Exception {
        Path path = Paths.get("src/test/resources/test1.csv");
        MockMultipartFile mockMultipartFile
                = new MockMultipartFile(
                "mockMultipartFile",
                "src/test/resources/test1.csv",
                MediaType.TEXT_PLAIN_VALUE,
                Files.readAllBytes(path)
        );

        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(multipart("/upload-csv-file").file(mockMultipartFile))
                .andExpect(status().isOk());

    }

    @Test
    public void whenFileUploaded_thenVerifyFailure() throws Exception {
        MockMvc mockMvc
                = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/upload-csv-file")
                .contentType(MediaType.MULTIPART_FORM_DATA);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound());
    }
}
