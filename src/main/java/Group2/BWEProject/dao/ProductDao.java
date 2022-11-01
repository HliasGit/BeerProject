package Group2.BWEProject.dao;

import Group2.BWEProject.model.Offer;
import Group2.BWEProject.model.Product;
import Group2.BWEProject.model.User;
import java.util.List;
import java.util.UUID;

public interface ProductDao {
    //* methods for handling object User and Database *//
    int insertProduct(UUID id, Product product); //why int??
    //id will be generated. Users are not supposed to fill it by themselves
    default int insertProduct(Product product) {
        UUID id = UUID.randomUUID(); //COUNTER ID
        return insertProduct(id, product);
    }
    //show all products of specific user
    List<Product> selectAllProducts();
    Product selectProductById(UUID id);
    int deleteProductById(UUID id);
    int updateProductById(UUID id, Product product);

    //TODO: getAllProducts => show all active products that are on auction
    //in auction class
}

