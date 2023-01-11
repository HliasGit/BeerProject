package com.pintbid.project.backend.api;

import com.pintbid.project.backend.models.User;
import com.pintbid.project.backend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTest {

    User user1 = new User("Name", "Surname", "Username", "Email", "Password");
    User user2 = new User("Name2", "Surname", "Username", "Email", "Password");
    List<User> list = new ArrayList<>();

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @BeforeEach
    void setup(){
        list.add(user1);
        list.add(user2);
        when(userService.selectAllUsers()).thenReturn(list);
        when(userService.selectUserById(user1.getId())).thenReturn(Optional.ofNullable(user1));
        when(userService.updateUser(user1)).thenReturn(user1);
        doNothing().when(userService).deleteUserById(user1.getId());
    }

    @Test
    void selectAllUsers() {
        ResponseEntity<List<User>> res = userController.selectAllUsers();
        assertEquals(res.getBody().get(0), user1);
    }

    @Test
    void selectUserById() {
        ResponseEntity<User> res = userController.selectUserById(user1.getId());
        assertEquals(res.getBody(), user1);
    }

    //TODO NEED TO BE FIXED
    @Test
    void createUser() {
        ResponseEntity<User> res = userController.createUser(user1);
        assertEquals(res.getBody(), user1);
    }

    @Test
    void deleteUserById() {
        ResponseEntity<Boolean> res = userController.deleteUserById(user1.getId());
        assertEquals(res.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    void updateUserById() {
        ResponseEntity<User> res = userController.updateUserById(user2.getId(), user1);
        assertEquals(res.getBody(), user1);
    }
}