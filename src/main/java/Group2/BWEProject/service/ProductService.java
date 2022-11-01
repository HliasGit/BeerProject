package Group2.BWEProject.service;

import Group2.BWEProject.dao.ProductDao;
import Group2.BWEProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductService(@Qualifier("productDao") ProductDao productDao) {
        this.productDao = productDao;
    }
    public int addProduct(Product product) {return productDao.insertProduct(product);}
    public List<Product> getAllProducts(){return productDao.selectAllProducts();}
    public Product selectProductById (UUID id){return productDao.selectProductById(id);}
    public int deleteProductById (UUID id) { return productDao.deleteProductById(id);};
    public int updateProductById (UUID id, Product product)
    { return productDao.updateProductById(id, product);}
}