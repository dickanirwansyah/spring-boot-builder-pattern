package com.spring.cart.springbootrestcart.service;

import com.spring.cart.springbootrestcart.entity.Product;
import com.spring.cart.springbootrestcart.request.GetRequestByIdproductRequest;
import com.spring.cart.springbootrestcart.request.InsertRequestProdduct;

import java.util.List;

public interface ProductService {

    Product createdProduct(InsertRequestProdduct request, String idcategory);
    Product findByIdProduct(GetRequestByIdproductRequest request);
    List<Product> listProduct();
}
