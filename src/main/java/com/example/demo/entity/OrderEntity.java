package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
    private int orderType;
    private double totalPrice;
    private double discount;
    private int status;
    private String reason;

    @OneToMany(mappedBy = "order")
    List<OrderDetailEntity> orderDetailList;

}
