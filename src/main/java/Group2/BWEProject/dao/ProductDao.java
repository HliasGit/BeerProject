package Group2.BWEProject.dao;

import Group2.BWEProject.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductDao {
    //* methods for handling object User and Database *//
    int insertProduct(UUID id, Product product); //int??
    //id will be generated. Users are not supposed to fill it by themselves
    default int insertProduct(Product product){
        UUID id = UUID.randomUUID();
        return  insertProduct(id, product);

        //TODO: deleteUser => delete User via id
        int deleteProduct(Product product);
        default int deleteProduct(Product product){
            return deleteProduct(product);
        }
        //TODO: getAllProducts => select all products as a list
        List<Product> showAllProducts(){
//            listAllProducts = new List <Product>;
            return listAllProducts(<product>);
        }

        //TODO: updateProduct => update properties of a product
        Product updateProduct(Product product){
            return updateProduct(product);
        }
    }




    //TODO: updateUser => update properties of User



}