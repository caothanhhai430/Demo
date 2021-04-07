package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AgencyDTO {
    private Long id;
    private String name;
    private int status;
    private int agencyLevel;

    List<AgencyDTO> agency_relationship = new ArrayList<>();
}
