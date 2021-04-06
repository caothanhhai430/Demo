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
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    private String productName;
    private int productPrice;
    private int status;
    String thumbnail;
    String images;

    @ManyToOne
    @JoinColumn(name = "manufactory_id")
    private ManufactoryEntity manufactory;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategoryEntity subCategory;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private InStockEntity inStock;

}
