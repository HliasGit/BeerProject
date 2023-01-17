package com.pintbid.project.backend.api;

import com.pintbid.project.backend.models.Product;
import com.pintbid.project.backend.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    Product product1 = new Product(11, 123,"Name", "Descr", "Image", 12.3,14.5, 13 );
    Product product2 = new Product(14, 123,"Name2", "Desc2r", "Image", 12.3,14.5, 13 );
    List<Product> list = new ArrayList<>();

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductController productController;

    @BeforeEach
    void setup() {
        list.add(product1);
        list.add(product2);
        when(productRepository.save(product1)).thenReturn(product1);
        when(productRepository.findAll()).thenReturn(list);
        when(productRepository.findById(product1.getId())).thenReturn(Optional.ofNullable(product1));
        doNothing().when(productRepository).deleteById(product1.getId());
        doNothing().when(productRepository).deleteAll();
    }

    @Test
    void createProduct() {
        ResponseEntity<Product> res = productController.createProduct(product1);
        assertEquals(res.getBody(), product1);
    }

    @Test
    void getAllProducts() {
        ResponseEntity<List<Product>> res = productController.getAllProducts(null);
        assertEquals(res.getBody().get(0), product1);
    }

    @Test
    void getProductById() {
        ResponseEntity<Product> res = productController.getProductById(product1.getId());
        assertEquals(res.getBody(), product1);
    }

    @Test //TODO IS RIGHT TO BE BOOLEAN AND NOT HTTP?
    void deleteProduct() {
        ResponseEntity<Boolean> res = productController.deleteProduct(product1.getId());
        assertEquals(res.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    void updateProduct() {
        ResponseEntity<Product> res = productController.updateProduct(product1.getId(), product2);
        assertEquals(res.getBody(), product1);
    }

    @Test
    void deleteAllTProducts() {
        ResponseEntity<HttpStatus> res = productController.deleteAllTProducts();
        assertEquals(res.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}