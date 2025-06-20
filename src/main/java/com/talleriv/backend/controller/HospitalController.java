package com.talleriv.backend.controller;

import com.talleriv.backend.models.Hospital;
import com.talleriv.backend.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @GetMapping
    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Hospital> getById(@PathVariable Long id) {
        return hospitalRepository.findById(id);
    }

    @PostMapping
    public Hospital create(@RequestBody Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @PutMapping("/{id}")
    public Hospital update(@PathVariable Long id, @RequestBody Hospital hospital) {
        hospital.setId(id);
        return hospitalRepository.save(hospital);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        hospitalRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        hospitalRepository.deleteAll();
    }
}