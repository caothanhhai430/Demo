package com.example.demo.repository;

import com.example.demo.entity.AgencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactoryRepository extends JpaRepository<AgencyEntity,Long> {
}