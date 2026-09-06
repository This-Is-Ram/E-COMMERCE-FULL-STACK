package com.ram.product_service.controller;

import com.ram.product_service.model.Product;
import com.ram.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        // return productService.addProduct(product);
        throw new RuntimeException("ADD PRODUCT ENDPOINT REACHED");
    }

    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return productService.addProducts(products);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProdById(@PathVariable Long id){
        return productService.getProdtctById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delProdById(@PathVariable Long id){
        String respose = productService.delProductById(id);

        if(respose.equals("Product Not Found")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respose);
        }

        return ResponseEntity.ok(respose);
    }


    @DeleteMapping("/deleteMultiple")
    public ResponseEntity<String> deleteAllProducts(@RequestBody List<Long> ids){
        String res = productService.deleteAllProducts(ids);

        return ResponseEntity.ok(res);
    }


}
