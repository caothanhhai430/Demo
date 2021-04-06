package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sub_category")
public class SubCategoryEntity extends BaseEntity{
    private String name;
    private int status;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "subCategory")
    List<ProductEntity> productList;
}
