package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.ProductRepository;
import com.example.demo.domain.product.RequestProduct;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        var allProducts = repository.findAllByActiveTrue();
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
            System.out.println(data.id() + " " + product);
            product.setName(data.name());
            product.setPrice(data.price());
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.ok().build();
    }


    @SuppressWarnings({ "null", "rawtypes" })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduto(@PathVariable String id ){
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            System.out.println(id + " " + product);
            product.setActive(false);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }


    ///@SuppressWarnings({ "rawtypes", "null" })
   // @PostMapping("/delete")
   // public ResponseEntity deleteProduct(@RequestBody @Valid RequestProduct data) {
   //     Optional<Product> optionalProduct = repository.findById(data.id());
   //     if (optionalProduct.isPresent()) {
    //        Product product = optionalProduct.get();
    //        repository.delete(product);
//
     //       return ResponseEntity.ok("apagado");
    //    }

    //    
    //    return ResponseEntity.ok("nao apagado");
   // }
}
