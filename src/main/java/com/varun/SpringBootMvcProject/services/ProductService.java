package com.varun.SpringBootMvcProject.services;

import com.varun.SpringBootMvcProject.models.Product;
import com.varun.SpringBootMvcProject.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Integer productId) {
        return productRepo.findById(productId).orElse(null);
    }
}
