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
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    private String name;
    private int status;


    @OneToMany(mappedBy = "category")
    List<SubCategoryEntity> subCategoryList;

    @OneToMany(mappedBy = "category")
    List<ProductEntity> productList;


}
