package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "order_detail")
public class OrderDetailEntity extends BaseEntity {
    private double totalPrice;
    private double discount;
    private int status;
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;



}
