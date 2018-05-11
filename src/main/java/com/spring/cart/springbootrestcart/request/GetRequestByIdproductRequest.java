package com.spring.cart.springbootrestcart.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetRequestByIdproductRequest {

    private String idproduct;
}
