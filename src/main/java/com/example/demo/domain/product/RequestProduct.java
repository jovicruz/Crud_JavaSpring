package com.example.demo.domain.product;

import com.example.demo.domain.product.ValidationGroups.PostValidation;
import com.example.demo.domain.product.ValidationGroups.PutValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO de Product juntamente com as validações necessarias de cada grupo de validação
public record RequestProduct(
    @NotBlank(message = "Id é necessario", groups = PutValidation.class) String id, 
    @NotBlank(message = "Name é necessario",groups = {PutValidation.class, PostValidation.class}) String name, 
    @NotNull(message = "Price é necessario",groups = {PutValidation.class, PostValidation.class}) Integer price
    ) {
    
}
