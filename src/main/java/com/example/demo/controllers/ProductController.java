package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductRepository;
import com.example.demo.domain.product.RequestProduct;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;


    @SuppressWarnings("rawtypes")
    @GetMapping("/")
    public ResponseEntity getMethodName() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/")
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }
    
    @SuppressWarnings({ "rawtypes", "null" })
    @Transactional
    @PutMapping("/")
    public ResponseEntity updateProduto(@RequestBody @Valid RequestProduct data) {
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice(data.price());
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.ok().build();
    }


    @SuppressWarnings({ "rawtypes", "null" })
    @PostMapping("/delete")
    public ResponseEntity deleteProduct(@RequestBody @Valid RequestProduct data) {
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            repository.delete(product);

            return ResponseEntity.ok("apagado");
        }

        
        return ResponseEntity.ok("nao apagado");
    }
}
