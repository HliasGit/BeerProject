package Group2.BWEProject.dao;

import Group2.BWEProject.model.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("productDao")
public class ProductDataAccessService implements ProductDao {
    private static List<Group2.BWEProject.model.Product> DBProduct = new ArrayList<>();

    @Override
    public int insertProduct(UUID id, Product product) {
        DBProduct.add(new Product(product.getId(),
                product.getUser(), product.getName(), product.getDescription(),
                product.getImage(), product.getMinPrice(), product.getExpectedPrice(),
                product.getExpectedDeliveryTimeInDays()));
        return 1;
    }

    @Override
    public List<Product> selectAllProducts() {
        return DBProduct;
    }

    @Override
    public Product selectProductById(UUID id) {
        for (Product product : DBProduct) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public int deleteProductById(UUID id) {
        for (Product product : DBProduct) {
            if (product.getId().equals(id)) {
                DBProduct.remove(product);
                return 1;
            }
        }
        return 0;
    }
    @Override
    public int updateProductById(UUID id, Product product) {
        for (Product product1 : DBProduct) {
            if (product1.getId().equals(id)) {
                DBProduct.remove(product);
                DBProduct.add(product);
                return 1;
            }
        }
        return 0;
    }
}