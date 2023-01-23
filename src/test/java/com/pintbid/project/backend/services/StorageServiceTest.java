package com.pintbid.project.backend.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class StorageServiceTest {

    MockMultipartFile fileObj = new MockMultipartFile("Test", "HelloWorld".getBytes());


    @Autowired
    private StorageService storageService;

    @MockBean
    private AmazonS3 s3client;

    @BeforeEach
    void setup(){
        doNothing().when(s3client).deleteObject("Test", "Test");
    }

    @Test
    void uploadFile() {
        String res = storageService.uploadFile(fileObj);
        res = res.substring(9,17);
        assertEquals(res, "uploaded");
    }

    @Test
    void downloadFile() {
        byte[] expectedFile = "Hello World!".getBytes();

        S3Object s3Object = new S3Object();
        S3ObjectInputStream s3ObjectInputStream = new S3ObjectInputStream(new ByteArrayInputStream(expectedFile), null);
        s3Object.setObjectContent(s3ObjectInputStream);
        when(s3client.getObject(any(), eq("myFile"))).thenReturn(s3Object);

        byte[] file = storageService.downloadFile("myFile");

        assertArrayEquals(expectedFile, file);
    }

    @Test
    void deleteFile() {
        String res = storageService.deleteFile(fileObj.getName());
        assertEquals(res, fileObj.getName() + " was removed");
    }
}