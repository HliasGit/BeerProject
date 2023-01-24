package com.pintbid.project.backend.payload.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class MessageResponseTest {

    private MessageResponse messageResponse = new MessageResponse("Test");

    @Test
    public void test() {
        messageResponse.setMessage("Test2");
        assertEquals("Test2", messageResponse.getMessage());
    }
}