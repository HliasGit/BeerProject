package com.pintbid.project.backend.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StorageServiceTest {

    MockMultipartFile fileObj = new MockMultipartFile("Test", "HelloWorld".getBytes());

    @Autowired
    private StorageService storageService;

    @MockBean
    private AmazonS3 s3client;

    @BeforeEach
    void setup(){
        Mockito.doNothing().when(s3client).deleteObject("Test", "Test");
    }

    @Test
    void uploadFile() {
        String res = storageService.uploadFile(fileObj);
        res = res.substring(9,17);
        assertEquals(res, "uploaded");
    }

    @Test
    void downloadFile() throws IOException {
    }

    @Test
    void deleteFile() {
        String res = storageService.deleteFile(fileObj.getName());
        assertEquals(res, fileObj.getName() + " was removed");
    }
}