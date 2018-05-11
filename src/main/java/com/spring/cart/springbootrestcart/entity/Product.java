package com.spring.cart.springbootrestcart.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
@Entity
@Table(name = "tabel_product")
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idproduct;

    @Column(name = "name", nullable = false)
    private String name;

    @Max(100)
    @Min(1)
    @Column(name = "stock", nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcategory", nullable = false)
    private Category category;

    @Column(name = "price", nullable = false)
    private long price;

    public Product(){}

    public Product(String idproduct, String name, int stock, Category category, long price){
        this.idproduct = idproduct;
        this.name = name;
        this.stock = stock;
        this.category = category;
        this.price = price;
    }
}
