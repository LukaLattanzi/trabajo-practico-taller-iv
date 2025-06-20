package com.talleriv.backend.service;

import com.talleriv.backend.models.Hospital;
import com.talleriv.backend.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    public Optional<Hospital> getById(Long id) {
        return hospitalRepository.findById(id);
    }

    public Hospital create(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public Hospital update(Long id, Hospital hospital) {
        hospital.setId(id);
        return hospitalRepository.save(hospital);
    }

    public void deleteById(Long id) {
        hospitalRepository.deleteById(id);
    }

    public void deleteAll() {
        hospitalRepository.deleteAll();
    }
}