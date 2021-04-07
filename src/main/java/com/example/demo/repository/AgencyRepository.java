package com.example.demo.repository;

import com.example.demo.entity.AgencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgencyRepository extends JpaRepository<AgencyEntity, Long> {
    @Query(value = "SELECT a.* FROM agency a INNER JOIN agency_manage m ON a.id = m.agency_id2 where m.agency_id1 = ?",nativeQuery = true)
    List<AgencyEntity> findAllAgencyLevel2(Long id);

    @Query(value = "SELECT a.* FROM agency a INNER JOIN agency_manage m ON a.id = m.agency_id1 where m.agency_id2 = ?",nativeQuery = true)
    List<AgencyEntity> findAllAgencyLevel1(Long id);
}