package com.spring.cart.springbootrestcart.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "tabel_orders_detils")
public class OrdersDetils {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String iddetils;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idorders", nullable = false)
    private Orders orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idproduct", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "total", nullable = false)
    private int total;

    public OrdersDetils(){}

    public OrdersDetils(String iddetils, Orders orders, Product product, int quantity, int total){
        this.iddetils = iddetils;
        this.orders = orders;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }
}
