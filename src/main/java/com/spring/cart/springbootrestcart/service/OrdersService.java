package com.spring.cart.springbootrestcart.service;

import com.spring.cart.springbootrestcart.entity.Orders;
import com.spring.cart.springbootrestcart.request.GetRequestByIdordersRequest;
import com.spring.cart.springbootrestcart.request.payload.OrdersPayload;

import java.util.List;

public interface OrdersService {

    Orders createdOrders(OrdersPayload orders);
    List<Orders> listOrders();
    Orders findByIdorders(GetRequestByIdordersRequest request);
}
