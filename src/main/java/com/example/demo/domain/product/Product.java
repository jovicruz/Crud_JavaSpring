package com.example.demo.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="product")
@Entity(name="product")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product{
    
    //ID é gerado automaticamente
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price;

    private Boolean active;

    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price = requestProduct.price();
        //Todos os novos produtos cadastrados são automaticamente ativos
        this.active = true;
    }
}
