package com.spring.cart.springbootrestcart.service;

import com.spring.cart.springbootrestcart.entity.Category;
import com.spring.cart.springbootrestcart.repository.CategoryRepository;
import com.spring.cart.springbootrestcart.request.GetRequestByIdRequest;
import com.spring.cart.springbootrestcart.request.InsertRequestCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createdCategory(InsertRequestCategory request) {
        Category category = newCategory(request.getName());
        categoryRepository.save(category);
        return category;
    }

    //builder pattern
    private Category newCategory(String name){
        return Category.builder()
                .name(name)
                .build();
    }

    @Override
    public Category findById(GetRequestByIdRequest request) {
       return categoryRepository.findByIdcategory(request.getIdcategory());
    }


    @Override
    public List<Category> findAllCategory() {
        List<Category> listcategory = new ArrayList<>();
        for(Category category : categoryRepository.findAll()){
            listcategory.add(category);
        }
        return listcategory;
    }
}
