package com.spring.cart.springbootrestcart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "tabel_category")
public class Category {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idcategory;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public Category(){}

    public Category(String idcategory, String name, List<Product> products){
        this.idcategory = idcategory;
        this.name = name;
        this.products = products;
    }

    public boolean isAddProduct(Product product){
        return products.add(product);
    }
}
