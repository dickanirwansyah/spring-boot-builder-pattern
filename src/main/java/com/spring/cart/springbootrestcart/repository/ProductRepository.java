package com.spring.cart.springbootrestcart.repository;

import com.spring.cart.springbootrestcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

    Optional<Product> findByIdproduct(String idproduct);
    Optional<Product> findByName(String name);
    Product findByIdproductIn(String idproduct);
}
