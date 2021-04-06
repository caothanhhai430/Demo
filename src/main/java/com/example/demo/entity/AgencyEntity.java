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
    private int agency_level;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "group",
            joinColumns = @JoinColumn(name = "agency_id_1"),
            inverseJoinColumns = @JoinColumn(name = "agency_id_2"))
    List<AgencyEntity> agencyList;
}
