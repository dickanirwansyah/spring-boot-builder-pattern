package com.spring.cart.springbootrestcart.repository;

import com.spring.cart.springbootrestcart.entity.Orders;
import com.spring.cart.springbootrestcart.entity.OrdersDetils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetilsRepository extends JpaRepository<OrdersDetils, String>{
}
