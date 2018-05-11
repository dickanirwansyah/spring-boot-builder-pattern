package com.spring.cart.springbootrestcart.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "tabel_orders")
public class Orders {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idorders;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "orders_date", nullable = false)
    private Date ordersDate;

    @NotBlank
    @Column(name = "orders_name", nullable = false)
    private String ordersName;

    @Email
    @NotBlank
    @Column(name = "orders_email", nullable = false)
    private String ordersEmail;

    @NotBlank
    @Column(name = "orders_phone", nullable = false)
    private String ordersPhone;

    @NotBlank
    @Column(name = "orders_address", nullable = false)
    private String ordersAddress;

}
