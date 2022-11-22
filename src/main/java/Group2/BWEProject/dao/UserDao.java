package Group2.BWEProject.dao;

import Group2.BWEProject.model.User;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao extends CrudRepository<User, UUID>{}
