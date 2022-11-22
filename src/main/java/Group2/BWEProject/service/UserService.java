package Group2.BWEProject.service;

import Group2.BWEProject.dao.UserDao;
import Group2.BWEProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("userDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public User addUser(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers(){
        return (List<User>) userDao.findAll();
    }

    public Optional<User> getUserById (UUID id){
        return userDao.findById(id);
    }

    public Boolean deleteUserById (UUID id) {
        userDao.deleteById(id);
        return true;
    }

    public User updateUserById (UUID id, User user) {
        return userDao.save(user);
    }
}
