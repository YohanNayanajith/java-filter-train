package com.example.interceptor.controller;

import com.example.interceptor.model.Product;
import com.example.interceptor.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @PostMapping("/")
    public ResponseEntity<Product> saveProducts(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.saveProduct(product));
    }
}
