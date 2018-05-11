package com.spring.cart.springbootrestcart.service;

import com.spring.cart.springbootrestcart.entity.Orders;
import com.spring.cart.springbootrestcart.entity.OrdersDetils;
import com.spring.cart.springbootrestcart.entity.Product;
import com.spring.cart.springbootrestcart.repository.OrdersDetilsRepository;
import com.spring.cart.springbootrestcart.repository.OrdersRepository;
import com.spring.cart.springbootrestcart.repository.ProductRepository;
import com.spring.cart.springbootrestcart.request.GetRequestByIdordersRequest;
import com.spring.cart.springbootrestcart.request.payload.OrdersPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class OrdersServiceImpl implements OrdersService{

    @Autowired private OrdersRepository ordersRepository;

    @Autowired private OrdersDetilsRepository ordersDetilsRepository;

    @Autowired private ProductRepository productRepository;

    @Override
    public Orders createdOrders(OrdersPayload ordersPayload) {
        Orders orders = newOrders(
                ordersPayload.getOrdersName(),
                ordersPayload.getOrdersEmail(),
                ordersPayload.getOrdersPhone(),
                ordersPayload.getOrdersAddress());

        ordersRepository.save(orders);
        List<OrdersDetils> ordersDetilsList = ordersPayload.getOrdersDetils();
        for(OrdersDetils ordersDetils : ordersDetilsList){
            OrdersDetils getOrders = new OrdersDetils();
            getOrders.setOrders(orders);
            String idproduct = ordersDetils.getProduct().getIdproduct();
            Product product = productRepository.findByIdproductIn(idproduct);
            getOrders.setProduct(product);
            getOrders.setQuantity(ordersDetils.getQuantity());
            getOrders.setTotal((int) (product.getPrice() * ordersDetils.getQuantity()));
            ordersDetilsRepository.save(getOrders);
        }
        return orders;
    }

    //builder orders
    private Orders newOrders(String ordersName, String ordersEmail, String ordersPhone, String ordersAddress){
        return Orders.builder()
                .ordersDate(new Date())
                .ordersName(ordersName)
                .ordersEmail(ordersEmail)
                .ordersPhone(ordersPhone)
                .ordersAddress(ordersAddress)
                .build();
    }

    @Override
    public List<Orders> listOrders() {
        List<Orders> ordersList = new ArrayList<>();
        for(Orders orders : ordersRepository.findAll()){
            ordersList.add(orders);
        }
        return ordersList;
    }

    @Override
    public Orders findByIdorders(GetRequestByIdordersRequest request) {
        return null;
    }
}
