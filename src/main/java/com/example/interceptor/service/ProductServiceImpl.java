package com.example.interceptor.service;

import com.example.interceptor.model.Product;
import com.example.interceptor.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
