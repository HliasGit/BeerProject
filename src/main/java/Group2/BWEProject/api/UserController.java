package Group2.BWEProject.api;

import Group2.BWEProject.model.User;
import Group2.BWEProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable("id") UUID id){
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "/{id}")
    public int deleteUserById(@PathVariable("id") UUID id){ return userService.deleteUserById(id);}

    @PutMapping(path = "{id}")
    public int updateUserById(@PathVariable("id") UUID id, @RequestBody User user) { return userService.updateUserById(id, user);}

    @GetMapping(path="/admin/{id}")
    public boolean isAdminById(@PathVariable("id") UUID id){ return userService.isAdminById(id);}
}
