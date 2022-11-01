package Group2.BWEProject.dao;

import Group2.BWEProject.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("userDao")
public class UserDataAccessService implements UserDao{

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getFirstName(), user.getLastName(), user.getUserName(), user.getEmail(), user.getPassword(), user.getAdmin()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public User selectUserById(UUID id) {
        User found = null;
        for (User user:DB){
            if(user.getId().equals(id))
                found = user;
        }
        return found;
    }

    @Override
    public int deleteUserById(UUID id) {
        for (User user:DB){
            if(user.getId().equals(id)) {
                DB.remove(user);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int updateUserById(UUID id, User userAdd) {
        for (User userDelete:DB){
            if (userDelete.getId().equals(id)){
                DB.remove(userDelete);
                DB.add(userAdd);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public boolean isAdminById(UUID id) {
        for (User user:DB){
            if (user.getId().equals(id)){
                return user.getAdmin();
            }
        }
        return false;
    }

}
