package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "in_stock")
public class InStockEntity extends BaseEntity {
    private int quantity;

    @OneToMany(mappedBy = "inStock")
    List<ProductEntity> productList;

    @OneToOne
    @JoinColumn(name = "agency_id")
    AgencyEntity agency;
}
