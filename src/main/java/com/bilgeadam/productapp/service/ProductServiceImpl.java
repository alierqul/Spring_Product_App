package com.bilgeadam.productapp.service;

import com.bilgeadam.productapp.entity.Product;
import com.bilgeadam.productapp.error.NotFoundExceptionRuntiime;
import com.bilgeadam.productapp.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional //org.springframework.transaction.annotation.Transactional;
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;


    public Product createProduct(Product product) {
        return repository.save(product);
    }


    public Product updateProduct(Product product) {

        Optional< Product > productDb = this.repository.findById(product.getId());

        if (productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            repository.save(productUpdate);
            return productUpdate;
        } else {
            throw new NotFoundExceptionRuntiime("Record not found with id : " + product.getId());
        }
    }


    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    public Product getProductById(long id) {

        Optional < Product > productDb = this.repository.findById(id);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {

            throw new NotFoundExceptionRuntiime("Record not found with id : " + id);
        }
    }

    public void deleteProduct(long id) {
        Optional < Product > productDb = this.repository.findById(id);

        if (productDb.isPresent()) {
            this.repository.delete(productDb.get());
        } else {
            throw new NotFoundExceptionRuntiime("Record not found with id : " + id);
        }

    }
}
