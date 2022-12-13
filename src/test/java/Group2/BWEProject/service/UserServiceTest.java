package Group2.BWEProject.service;

import Group2.BWEProject.model.User;
import Group2.BWEProject.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceTest {

    UUID random = UUID.randomUUID();
    Optional<User> user = Optional.of(new User("Ciao", "Vaffanculo", "ciaostrono@gmail.com", "password", false));


    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setup(){
        Mockito.when(userRepository.findById(random)).thenReturn(user);
        Mockito.when(userRepository.save(user.get())).thenReturn(user.get());
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
        User userFound = userService.addUser(user.get());
        assertEquals(userName, userFound.getFirstName());
    }
}