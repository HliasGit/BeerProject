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

import static org.junit.jupiter.api.Assertions.*;
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
        when(productRepository.findByNameContaining("test")).thenReturn(list);
    }

    @Test
    void getAllProductsByName() {
        List<Product> res = productService.getAllProductsByName("test");
        assertEquals(res.get(0), product1);
    }
}