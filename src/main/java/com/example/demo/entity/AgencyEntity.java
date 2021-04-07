package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "agency")
public class AgencyEntity extends BaseEntity {
    private String name;
    private int status;
    private int agencyLevel;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "agency_manage",
            joinColumns = @JoinColumn(name = "agency_id1",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "agency_id2",referencedColumnName = "id"))
    List<AgencyEntity> agencyList;
}
