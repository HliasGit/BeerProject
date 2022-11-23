package Group2.BWEProject.service;

import Group2.BWEProject.repository.UserRepository;
import Group2.BWEProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> selectAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> selectUserById(UUID id){
        return userRepository.findById(id);
    }

    public Boolean deleteUserById (UUID id) {
        userRepository.deleteById(id);
        return true;
    }

    public User updateUserById (UUID id, User user) {
        return userRepository.save(user);
    }
}
