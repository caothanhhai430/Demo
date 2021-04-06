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
@Table(name = "manufactory")
public class ManufactoryEntity extends BaseEntity {
    private String name;
    private int status;

    @OneToMany(mappedBy = "manufactory")
    List<ProductEntity> productList;
}
