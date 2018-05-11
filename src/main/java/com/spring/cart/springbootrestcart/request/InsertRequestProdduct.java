package com.spring.cart.springbootrestcart.request;

import com.spring.cart.springbootrestcart.entity.Category;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class InsertRequestProdduct {

    @NotBlank
    private String name;

    @NotNull
    private Category categoryId;

    @Max(100)
    @Min(1)
    @NotNull
    private int stock;

    @NotNull
    private long price;
}
