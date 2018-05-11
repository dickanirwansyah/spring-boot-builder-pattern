package com.spring.cart.springbootrestcart.repository;

import com.spring.cart.springbootrestcart.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String>{
}
