package com.ram.product_service.service;

import com.ram.product_service.model.Product;
import com.ram.product_service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepo productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> addProducts(List<Product> products) {
        return productRepo.saveAll(products);
    }

    public Optional<Product> getProdtctById(Long id) {
        return productRepo.findById(id);
    }



    public String delProductById(Long id) {

        Optional<Product> optionalProduct = productRepo.findById(id);

        if(optionalProduct.isEmpty()) {
            return "Product Not Found";
        }

        productRepo.deleteById(id);

        return "Product Deleted Successfully";
    }

    public String deleteAllProducts(List<Long> ids) {
        productRepo.deleteAllById(ids);
        return "All Products Deleted Successfully";
    }
}
