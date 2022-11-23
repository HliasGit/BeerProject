package Group2.BWEProject.service;

import Group2.BWEProject.repository.ProductRepository;
import Group2.BWEProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(@Qualifier("productDao") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {return productRepository.save(product);}
    public List<Product> selectAllProducts(){return (List<Product>) productRepository.findAll();}
    public Optional<Product> selectProductById (UUID id){return productRepository.findById(id);}
    public Boolean deleteProductById (UUID id) {
        productRepository.deleteById(id);
        return true;
    }
    public Product updateProductById (UUID id, Product product)
    { return productRepository.save(product);}
}