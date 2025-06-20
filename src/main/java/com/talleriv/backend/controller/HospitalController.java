package com.talleriv.backend.controller;

import com.talleriv.backend.models.Hospital;
import com.talleriv.backend.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping
    public List<Hospital> getAll() {
        return hospitalService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Hospital> getById(@PathVariable Long id) {
        return hospitalService.getById(id);
    }

    @PostMapping
    public Hospital create(@RequestBody Hospital hospital) {
        return hospitalService.create(hospital);
    }

    @PutMapping("/{id}")
    public Hospital update(@PathVariable Long id, @RequestBody Hospital hospital) {
        return hospitalService.update(id, hospital);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        hospitalService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        hospitalService.deleteAll();
    }
}