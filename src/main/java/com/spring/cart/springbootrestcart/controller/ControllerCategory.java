package com.spring.cart.springbootrestcart.controller;

import com.spring.cart.springbootrestcart.entity.Category;
import com.spring.cart.springbootrestcart.exception.BadRequestException;
import com.spring.cart.springbootrestcart.request.GetRequestByIdRequest;
import com.spring.cart.springbootrestcart.request.InsertRequestCategory;
import com.spring.cart.springbootrestcart.request.response.ResponseApi;
import com.spring.cart.springbootrestcart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/category")
public class ControllerCategory {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/created")
    public ResponseEntity<Category> createdCategory(@Valid @RequestBody InsertRequestCategory category){
        return Optional.ofNullable(categoryService.createdCategory(category))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/{idcategory}")
    public ResponseEntity<Category> findByIdcategory(@PathVariable(value = "idcategory") String idcategory){
        GetRequestByIdRequest byIdRequest = GetRequestByIdRequest
                .builder().idcategory(idcategory).build();
        Category category = categoryService.findById(byIdRequest);
        if(category == null){
            return new ResponseEntity(new ResponseApi("data tidak ada", false),HttpStatus.BAD_REQUEST);
        }else{
           return new ResponseEntity<Category>(category, HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Category>> listCategory(){
        return Optional.ofNullable(categoryService.findAllCategory())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND));
    }
}
