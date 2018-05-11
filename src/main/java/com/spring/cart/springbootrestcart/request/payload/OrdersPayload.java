package com.spring.cart.springbootrestcart.request.payload;

import com.spring.cart.springbootrestcart.entity.OrdersDetils;

import java.util.ArrayList;
import java.util.List;

public class OrdersPayload {

    private String ordersName;
    private String ordersEmail;
    private String ordersPhone;
    private String ordersAddress;
    private List<OrdersDetils> ordersDetils = new ArrayList<>();

    public String getOrdersName(){
        return ordersName;
    }

    public String getOrdersEmail(){
        return ordersEmail;
    }

    public String getOrdersPhone(){
        return ordersPhone;
    }

    public String getOrdersAddress(){
        return ordersAddress;
    }

    public List<OrdersDetils> getOrdersDetils(){
        return ordersDetils;
    }
}
