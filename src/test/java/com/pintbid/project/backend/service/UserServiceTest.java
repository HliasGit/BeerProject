package com.pintbid.project.backend.service;


import com.pintbid.project.backend.models.User;
import com.pintbid.project.backend.repository.UserRepository;
import com.pintbid.project.backend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    User user1 = new User("Ciao", "Vaffanculo", "userCiao","ciaostrono@gmail.com", "password");
    User user2 =new User("Cane", "Stuffs","userCane", "afasano@gmail.com", "password");
    List<User> userList = new ArrayList<>();

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        userList.add(user1);
        userList.add(user2);
    }

    @Test
    public void testGetUserById(){
        when(userRepository.findById(user1.getId())).thenReturn(Optional.ofNullable(user1));
        Optional<User> result = userService.selectUserById(user1.getId());

        String userName = user1.getFirstName();
        assertEquals(userName, result.get().getFirstName());
    }

    @Test
    public void testAddUser(){
        when(userRepository.save(user1)).thenReturn(user1);
        User result = userService.addUser(user1);
        assertEquals(result.getFirstName(),"Ciao");
    }

    @Test
    public void testSelectAllUsers(){
        when(userRepository.findAll()).thenReturn(userList);
        String userName = "Cane";
        User result = userService.selectAllUsers().get(1);
        assertEquals(result.getFirstName(), userName);
    }

    @Test
    public void testUpdateUser(){
        when(userRepository.save(user1)).thenReturn(user1);
        String newName ="Lucia";
        user1.setFirstName(newName);
        User result = userService.updateUser(user1);
        assertEquals("Lucia", result.getFirstName());
    }
}