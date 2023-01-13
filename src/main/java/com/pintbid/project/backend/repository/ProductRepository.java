package com.pintbid.project.backend.repository;


import com.pintbid.project.backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    List<Product> findByNameContaining(String name);


}

