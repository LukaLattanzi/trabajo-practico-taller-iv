package com.talleriv.backend.service;

import com.talleriv.backend.models.Staff;
import com.talleriv.backend.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    public Optional<Staff> getById(Long id) {
        return staffRepository.findById(id);
    }

    public Staff create(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff update(Long id, Staff staff) {
        staff.setId(id);
        return staffRepository.save(staff);
    }

    public void deleteById(Long id) {
        staffRepository.deleteById(id);
    }

    public void deleteAll() {
        staffRepository.deleteAll();
    }
}