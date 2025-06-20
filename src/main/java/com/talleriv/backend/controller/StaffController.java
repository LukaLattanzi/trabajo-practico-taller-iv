package com.talleriv.backend.controller;

import com.talleriv.backend.models.Staff;
import com.talleriv.backend.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Staff> getById(@PathVariable Long id) {
        return staffRepository.findById(id);
    }

    @PostMapping
    public Staff create(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    @PutMapping("/{id}")
    public Staff update(@PathVariable Long id, @RequestBody Staff staff) {
        staff.setId(id);
        return staffRepository.save(staff);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        staffRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        staffRepository.deleteAll();
    }
}