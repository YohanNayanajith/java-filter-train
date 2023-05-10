package com.example.interceptor.service;

import com.example.interceptor.model.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);

    public List<Product> getAllProducts();
}
