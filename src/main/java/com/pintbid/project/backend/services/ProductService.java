package com.pintbid.project.backend.services;

import com.pintbid.project.backend.models.Product;
import com.pintbid.project.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(@Qualifier("productRepository")ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){return productRepository.save(product);}

    public List<Product> getAllProducts(){return productRepository.findAll();}

    public List<Product> getAllProductsByName(String name){return productRepository.findByNameContaining(name);}

    public Optional<Product> getProductByID(Integer id){return productRepository.findById(id);}

    public Boolean deleteProductByID(Integer id){
        productRepository.deleteById(id);
        return true;
    }

    public Boolean deleteAllProducts(){
        productRepository.deleteAll();
        return true;
    }
}
