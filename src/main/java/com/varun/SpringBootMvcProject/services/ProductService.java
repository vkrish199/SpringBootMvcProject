package com.varun.SpringBootMvcProject.services;

import com.varun.SpringBootMvcProject.models.Product;
import com.varun.SpringBootMvcProject.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product addOrUpdateProduct(Product product, MultipartFile image)
            throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productRepo.save(product);
    }

    public void deleteProductById(Integer productId) {
        productRepo.deleteById(productId);
    }

    public List<Product> searchProductsByKeyword(String keyword) {
        return productRepo.searchProducts(keyword);
    }
}
