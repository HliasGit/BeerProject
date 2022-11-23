package Group2.BWEProject.repository;


import Group2.BWEProject.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository("productDao")
public interface ProductRepository extends CrudRepository<Product, UUID> {


}

