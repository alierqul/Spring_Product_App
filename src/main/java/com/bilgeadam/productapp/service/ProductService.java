package com.bilgeadam.productapp.service;

import com.bilgeadam.productapp.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(long id);
    void deleteProduct(long id);

}
