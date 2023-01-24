package com.pintbid.project.backend.payload.response;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoResponseTest {

    private UserInfoResponse info = new UserInfoResponse(1, "Name", "Last", "User", "email", Arrays.asList(new String("ROLE_USER")));

    @Test
    public void testAll(){
        info.setId(1);
        assertEquals(1, info.getId());
        info.setFirstname("FirstName");
        assertEquals("FirstName", info.getFirstname());
        info.setLastname("LastName");
        assertEquals("LastName", info.getLastname());
        info.setUsername("UserName");
        assertEquals("UserName", info.getUsername());
        info.setEmail("emailSet");
        assertEquals("emailSet", info.getEmail());
        assertEquals("ROLE_USER", info.getRoles().get(0));
    }
}