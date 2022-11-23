package Group2.BWEProject.repository;

import Group2.BWEProject.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, UUID>{}
