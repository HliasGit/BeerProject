package Group2.BWEProject.service;

import Group2.BWEProject.model.User;
import Group2.BWEProject.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceTest {

    UUID random = UUID.randomUUID();
    Optional<User> user1 = Optional.of(new User("Ciao", "Vaffanculo", "ciaostrono@gmail.com", "password", false));
    Optional<User> user2 = Optional.of(new User("Cane", "Stuffs", "afasano@gmail.com", "password", false));
    List<User> userList = new ArrayList<>();

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setup(){
        userList.add(user1.get());
        userList.add(user2.get());

        Mockito.when(userRepository.findById(random)).thenReturn(user1);
        Mockito.when(userRepository.save(user1.get())).thenReturn(user1.get());
        Mockito.when(userRepository.findAll()).thenReturn(userList);
    }

    @Test
    public void testGetUserByIdSuccess(){
        String userName = "Ciao";
        User userFound = userService.selectUserById(random).get();
        assertEquals(userName, userFound.getFirstName());
    }

    @Test
    public void testAddUser(){
        String userName = "Ciao";
        User userFound = userService.addUser(user1.get());
        assertEquals(userName, userFound.getFirstName());
    }

    @Test
    public void testSelectAllUsers(){
        String userName = "Cane";
        User userFound = userService.selectAllUsers().get(1);
        assertEquals(userFound.getFirstName(), userName);
    }
}