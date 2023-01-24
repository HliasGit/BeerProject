package com.pintbid.project.backend.models;

import com.pintbid.project.backend.utils.ERole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    private Role role = new Role();

    @Test
    void fullTest() {
        role.setId(1);
        assertEquals(1, role.getId());
        role.setName(ERole.ROLE_USER);
        assertEquals(ERole.ROLE_USER, role.getName());
    }
}