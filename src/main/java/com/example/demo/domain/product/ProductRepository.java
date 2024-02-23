package com.example.demo.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, String> {
    //Metodo que filtra todos os produtos marcados como ativo
    List<Product> findAllByActiveTrue();
}
