package Group2.BWEProject.dao;


import Group2.BWEProject.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository("productDao")
public interface ProductDao extends CrudRepository<Product, UUID> {


}

