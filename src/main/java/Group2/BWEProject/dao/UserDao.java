package Group2.BWEProject.dao;

import Group2.BWEProject.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {

    int insertUser(UUID id, User user);

    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();

    User selectUserById(UUID id);

    int deleteUserById(UUID id);

    int updateUserById(UUID id, User user);

    boolean isAdminById(UUID id);

}
