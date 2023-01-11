package com.pintbid.project.backend.api;

import com.pintbid.project.backend.services.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

@SpringBootTest
class StorageControllerTest {

    MockMultipartFile file = new MockMultipartFile("Test", "Hello".getBytes());

    @Autowired
    private StorageController storageController;

    @MockBean
    private StorageService storageService;

    @BeforeEach
    void setup(){
        when(storageService.uploadFile(file)).thenReturn("Hello");
        when(storageService.downloadFile("Hello")).thenReturn("Hello".getBytes());
        when(storageService.deleteFile("Hello")).thenReturn("Test");
    }

    @Test
    void uploadFile() {
        ResponseEntity<String> res = storageController.uploadFile(file);
        assertEquals(res.getBody(), "Hello");
    }

    @Test
    void downloadFile() {
        ResponseEntity<ByteArrayResource> res = storageController.downloadFile("Hello");
        ByteArrayResource resource = new ByteArrayResource("Hello".getBytes());
        assertEquals(res.getBody(), resource);
    }

    @Test
    void deleteFile() {
        ResponseEntity<String> res = storageController.deleteFile("Hello");
        assertEquals(res.getBody(), "Test");
    }
}