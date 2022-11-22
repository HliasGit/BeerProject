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

    public Product addProduct(Product product) {return productDao.save(product);}
    public List<Product> selectAllProducts(){return (List<Product>)productDao.findAll();}
    public Optional<Product> selectProductById (UUID id){return productDao.findById(id);}
    public Boolean deleteProductById (UUID id) {
        productDao.deleteById(id);
        return true;
    }
    public Product updateProductById (UUID id, Product product)
    { return productDao.save(product);}
}