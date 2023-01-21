package com.pintbid.project.backend.services;


import com.pintbid.project.backend.models.Product;
import com.pintbid.project.backend.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

    Product product1 = new Product(11, 123,"Name", "Descr", "Image", 12.3,14.5, 13 );
    Product product2 = new Product(14, 123,"Name2", "Desc2r", "Image", 12.3,14.5, 13 );
    List<Product> list = new ArrayList<>();

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @BeforeEach
    void setup(){
        list.add(product1);
        list.add(product2);
        doNothing().when(productRepository).deleteById(product1.getId());
        doNothing().when(productRepository).deleteAll();
        when(productRepository.findById(product1.getId())).thenReturn(Optional.ofNullable(product1));
        when(productRepository.findAll()).thenReturn(list);
        when(productRepository.save(product1)).thenReturn(product1);
        when(productRepository.findByNameContaining("test")).thenReturn(list);
    }

    @Test
    void testGetAllProductsByName() {
        List<Product> res = productService.getAllProductsByName("test");
        assertEquals(res.get(0), product1);
    }

    @Test
    void testCreateProduct(){
        Product res = productService.createProduct(product1);
        assertEquals(res, product1);
    }

    @Test
    void testGetAllProducts(){
        List<Product> res = productService.getAllProducts();
        assertEquals(res.get(0), product1);
    }

    @Test
    void testGetProductByID(){
        Optional<Product> res = productService.getProductByID(product1.getId());
        assertEquals(res.get(), product1);
    }

    @Test
    void testUpdateProduct(){
        Product res = productService.updateProduct(product2.getId(), product1);
        assertEquals(product1.getId(), res.getId());
    }

    @Test
    void testDeleteProductByID(){
        Boolean res = productService.deleteProductByID(product1.getId());
        assertEquals(res, true);
    }

    @Test
    void testDeleteAll(){
        Boolean res = productService.deleteAllProducts();
        assertEquals(res, true);
    }
}