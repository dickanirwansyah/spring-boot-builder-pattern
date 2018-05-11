package com.spring.cart.springbootrestcart.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class InsertRequestCategory {

    @NotBlank
    private String name;
}
