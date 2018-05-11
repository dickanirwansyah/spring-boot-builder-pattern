package com.spring.cart.springbootrestcart.controller;

import com.spring.cart.springbootrestcart.entity.Orders;
import com.spring.cart.springbootrestcart.request.payload.OrdersPayload;
import com.spring.cart.springbootrestcart.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/orders")
public class ControllerOrders {

    @Autowired
    private OrdersService ordersService;

    @PostMapping(value = "/created")
    public ResponseEntity<Orders> createdOrders(@Valid @RequestBody OrdersPayload ordersPayload){
        return Optional.ofNullable(ordersService.createdOrders(ordersPayload))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Orders>(HttpStatus.BAD_REQUEST));
    }
}
