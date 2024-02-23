package com.example.demo.domain.product;

import jakarta.validation.groups.Default;

//Grupos de validação para os metodos Post e Put
public class ValidationGroups {
    public interface PostValidation extends Default {}
    public interface PutValidation extends Default {}
}
