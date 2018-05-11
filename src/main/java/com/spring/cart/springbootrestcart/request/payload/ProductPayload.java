package com.spring.cart.springbootrestcart.request.payload;

import com.spring.cart.springbootrestcart.entity.Category;
import com.spring.cart.springbootrestcart.entity.Product;

public class ProductPayload {

    private String idproduct;
    private String name;
    private Category category;
    private int stock;
    private long price;

    public ProductPayload(Product product){
        this.idproduct = product.getIdproduct();
        this.name = product.getName();
        this.category = product.getCategory();
        this.stock = product.getStock();
        this.price = product.getPrice();
    }

    public ProductPayload(String idproduct, String name, Category category, int stock, long price){
        this.idproduct = idproduct;
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    public String getIdproduct(){
        return idproduct;
    }

    public void setIdproduct(String idproduct){
        this.idproduct = idproduct;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public long getPrice(){
        return price;
    }

    public void setPrice(long price){
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }
}
