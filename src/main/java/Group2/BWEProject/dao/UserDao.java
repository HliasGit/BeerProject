package Group2.BWEProject.dao;

import Group2.BWEProject.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository("userDao")
public interface UserDao extends CrudRepository<User, UUID>{}
