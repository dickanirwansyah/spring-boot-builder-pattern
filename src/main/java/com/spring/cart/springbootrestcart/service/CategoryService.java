package com.spring.cart.springbootrestcart.service;

import com.spring.cart.springbootrestcart.entity.Category;
import com.spring.cart.springbootrestcart.request.GetRequestByIdRequest;
import com.spring.cart.springbootrestcart.request.InsertRequestCategory;

import java.util.List;

public interface CategoryService {

    Category createdCategory(InsertRequestCategory request);
    Category findById(GetRequestByIdRequest request);
    List<Category> findAllCategory();
}
