package Group2.BWEProject.dao;

import Group2.BWEProject.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("userDao")
public class UserDataAccessRepository implements  UserDao{

    //list as our database
    private static List<User> dbRecordUsers = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        dbRecordUsers.add(new User(id,user.getFirstName(), user.getLastName(),user.getUserName(), user.getEmail(), user.getPassword()));
        return 1;
    }


    //TODO: getAllUsers to list all users as a list
    @Override
    public List<User> getAllUsers() {
        return dbRecordUsers;
    }

    //TODO: deleteUser to delete User via id


    //TODO: updateUser to update properties of User

}
