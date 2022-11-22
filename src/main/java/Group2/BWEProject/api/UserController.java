package Group2.BWEProject.api;

import Group2.BWEProject.model.User;
import Group2.BWEProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> selectAllUsers(){
        return new ResponseEntity<>(userService.selectAllUsers(), HttpStatus.FOUND);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<User>> selectUserById(@PathVariable("id") UUID id){
        return new ResponseEntity<>(userService.selectUserById(id), HttpStatus.FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable("id") UUID id){
        return new ResponseEntity<Boolean>(userService.deleteUserById(id), HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") UUID id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUserById(id, user), HttpStatus.CREATED);
    }
   }
