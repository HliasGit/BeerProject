package com.pintbid.project.backend.services;

import com.pintbid.project.backend.models.User;
import com.pintbid.project.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> selectUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User addUser(User user) {
        return  userRepository.save(user);

    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    public void deleteAllUsers() {
       userRepository.deleteAll();
    }
}
