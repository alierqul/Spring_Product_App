package com.bilgeadam.productapp.controller;

import com.bilgeadam.productapp.entity.Product;
import com.bilgeadam.productapp.service.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public  List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    public  Product  getProductById(@PathVariable("id" ) long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public ResponseEntity< Product > createProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(this.productService.createProduct(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable long id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.productService.deleteProduct(id);
        return HttpStatus.OK;
    }
}

