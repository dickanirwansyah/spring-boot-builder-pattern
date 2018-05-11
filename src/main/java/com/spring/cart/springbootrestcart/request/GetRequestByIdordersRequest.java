package com.spring.cart.springbootrestcart.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class GetRequestByIdordersRequest {

    @NotBlank
    private String idorders;
}
