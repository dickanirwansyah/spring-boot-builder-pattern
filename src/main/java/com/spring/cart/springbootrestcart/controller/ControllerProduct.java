package com.spring.cart.springbootrestcart.controller;

import com.spring.cart.springbootrestcart.entity.Product;
import com.spring.cart.springbootrestcart.request.GetRequestByIdproductRequest;
import com.spring.cart.springbootrestcart.request.InsertRequestProdduct;
import com.spring.cart.springbootrestcart.request.response.ResponseApi;
import com.spring.cart.springbootrestcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ControllerProduct {

    @Autowired private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(){
        return Optional.ofNullable(productService.listProduct())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/{idproduct}")
    public ResponseEntity<Product> findByIdproduct(@PathVariable String idproduct){
        GetRequestByIdproductRequest requestByIdproduct = GetRequestByIdproductRequest
                .builder().idproduct(idproduct).build();
        Product resultProduct = productService.findByIdProduct(requestByIdproduct);

        if(resultProduct == null){
            return new ResponseEntity(new ResponseApi("data tidak ada", false), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
    }

    @PostMapping(value = "/created/{categoryId}/build")
    public ResponseEntity<Product> createdProduct(@Valid @RequestBody InsertRequestProdduct request,
                                                  @PathVariable String categoryId){

        return Optional.ofNullable(productService.createdProduct(request, categoryId))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Product>(HttpStatus.BAD_REQUEST));
    }
}
