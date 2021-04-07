package com.example.demo.controller;


import com.example.demo.dto.AgencyDTO;
import com.example.demo.entity.AgencyEntity;
import com.example.demo.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/agency")
public class AgencyController {

    @Autowired
    AgencyRepository agencyRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addAgency(@RequestBody AgencyDTO agencyDTO) {
        AgencyEntity agencyEntity = new AgencyEntity();
        agencyEntity.setName(agencyDTO.getName());
        agencyEntity.setAgencyLevel(agencyDTO.getAgencyLevel());
        agencyEntity.setStatus(0);
        agencyEntity = agencyRepository.save(agencyEntity);
        Map<String, Object> res = new HashMap<>();
        res.put("message","create Agency success");
        res.put("data",agencyEntity);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/{id}/info", method = RequestMethod.PUT)
    public ResponseEntity updateAgencyInfo(@PathVariable Long id, @RequestBody AgencyDTO agencyDTO) {
        AgencyEntity agencyEntity = agencyRepository.findById(id).orElseThrow(() -> new RuntimeException("Agency not found"));
        agencyEntity.setName(agencyDTO.getName());
        agencyEntity.setAgencyLevel(agencyDTO.getAgencyLevel());
        agencyEntity.setStatus(0);
        agencyRepository.save(agencyEntity);
        Map<String, Object> res = new HashMap<>();
        res.put("message","Update Agency info success");
        res.put("data",agencyEntity);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/{id}/relationship", method = RequestMethod.PUT)
    public ResponseEntity updateAgencyRelationship(@PathVariable Long id, @RequestBody Map<String, List<Long>> data) {
        List<Long> agencyIds = data.get("agencyIds");
        AgencyEntity agencyEntity = agencyRepository.findById(id).orElseThrow(() -> new RuntimeException("Agency not found"));
        List<AgencyEntity> agencyEntityList = agencyRepository.findAllById(agencyIds);
        if (agencyEntityList.stream().anyMatch(e -> agencyEntity.getAgencyLevel() == e.getAgencyLevel())) {
            throw new RuntimeException("Cannot update relationship because agency_level must be different");
        }
        agencyEntity.setAgencyList(agencyEntityList);
        agencyRepository.save(agencyEntity);
        Map<String, Object> res = new HashMap<>();
        res.put("message","Update Agency relationship success");
        res.put("data",agencyEntity);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity detailAgency(@PathVariable Long id) {
        AgencyEntity agencyEntity = agencyRepository.findById(id).orElseThrow(() -> new RuntimeException("Agency not found"));
        List<AgencyEntity> agencyEntityList = null;
        if(agencyEntity.getAgencyLevel()==1){
            agencyEntityList =  agencyRepository.findAllAgencyLevel2(id);
        }else {
            agencyEntityList = agencyRepository.findAllAgencyLevel1(id);
        }
        agencyEntityList.stream().forEach(e->e.setAgencyList(null));
        agencyEntity.setAgencyList(agencyEntityList);
        Map<String, Object> res = new HashMap<>();
        res.put("message","Get detail Agency success");
        res.put("data",agencyEntity);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity list(Pageable pageable) {
        List<AgencyEntity> list = agencyRepository.findAll(pageable).getContent();
        return ResponseEntity.ok(list);
    }
}
