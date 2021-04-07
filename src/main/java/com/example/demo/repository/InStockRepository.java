package com.example.demo.repository;

import com.example.demo.entity.AgencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InStockRepository extends JpaRepository<AgencyEntity,Long> {
}