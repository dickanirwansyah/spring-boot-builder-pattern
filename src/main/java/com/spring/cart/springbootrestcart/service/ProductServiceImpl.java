package com.spring.cart.springbootrestcart.service;

import com.spring.cart.springbootrestcart.entity.Category;
import com.spring.cart.springbootrestcart.entity.Product;
import com.spring.cart.springbootrestcart.repository.CategoryRepository;
import com.spring.cart.springbootrestcart.repository.ProductRepository;
import com.spring.cart.springbootrestcart.request.GetRequestByIdproductRequest;
import com.spring.cart.springbootrestcart.request.InsertRequestProdduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired private ProductRepository productRepository;

    @Autowired private CategoryRepository categoryRepository;

    @Override
    public Product createdProduct(InsertRequestProdduct request, String idcategory) {
        Category category = categoryRepository.findByIdcategory(idcategory);
        Product product = newProduct(
                request.getName(),
                request.getCategoryId(),
                request.getStock(),
                request.getPrice());
        category.isAddProduct(product);
        categoryRepository.save(category);
        return productRepository.save(product);
    }

    //builder product
    private Product newProduct(String name, Category category, int stock, long price){
        return Product.builder()
                .name(name)
                .category(category)
                .stock(stock)
                .price(price)
                .build();
    }

    @Override
    public List<Product> listProduct() {
        List<Product> productList = new ArrayList<>();
        for(Product product : productRepository.findAll()){
            productList.add(product);
        }
        return productList;
    }

    @Override
    public Product findByIdProduct(GetRequestByIdproductRequest request) {
        return productRepository.findByIdproductIn(request.getIdproduct());
    }

}
